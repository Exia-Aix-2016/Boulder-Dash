package dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

/**
 * MapDAO
 * CRUD with DataBase
 * @see IMap
 * @see Dao
 * @version 1.0
 */
public class MapDAO implements IMap {

    /**
     * Connection dataBase
     * */
    private Connection connection;
    private static CallableStatement statement;

    /**
     * Constructor
     * initialize dao and get connection
     * */
   public MapDAO(){
       this.connection = Dao.getInstance().getConnection();
    }
    //CRUD
    @Override
    public void addObjectType(final ObjectType objectType){
        //Array of parameters
        ArrayList<Parameters> parameters = new ArrayList<>();
        parameters.add(new Parameters<>(objectType.name(), TypeParameters.IN));
        this.createCallableStatement("boulderdash.addObjectType(?)", parameters).ifPresent(MapDAO::executeCallStatement);
    }

    @Override
    public void removeObjectType(final ObjectType objectType){
        //Array of parameters
        ArrayList<Parameters> parameters = new ArrayList<>();
        parameters.add(new Parameters<>(objectType.name(), TypeParameters.IN));
        this.createCallableStatement("boulderdash.removeObjectType(?)", parameters).ifPresent(MapDAO::executeCallStatement);
    }

    @Override
    public Optional<RawMap> getMap(final String nameMap) {

        //Init attributs
        Integer width = 0, height = 0, nbrDiamond = 0, timeRemaining = 0, x = 0, y = 0;
        RawMap rawMap;
        Optional<ResultSet> oResult;
        ArrayList<Parameters> parameters = new ArrayList<>();

        //============= Step 1 : Get Dimension / number of diamond / time remaining of this map =============
        parameters.add(new Parameters<>(nameMap, TypeParameters.IN));
        this.createCallableStatement("boulderdash.getMap(?)", parameters).ifPresent(MapDAO::executeCallStatement);
        //get ResultSet
        oResult = MapDAO.getResultSet();
        if(oResult.isPresent()){
            try {
                while (oResult.get().next()){
                    //get specs
                    width = (Integer)oResult.get().getObject("Width");
                    height = (Integer)oResult.get().getObject("Heigth");
                    nbrDiamond = (Integer)oResult.get().getObject("Diamond");
                    timeRemaining = (Integer)oResult.get().getObject("RemainingTime");
                    if(width == null || height == null || nbrDiamond == null || timeRemaining == null){
                        return Optional.empty();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return Optional.empty();
            }
        }else {
            return Optional.empty();
        }

        //============= Step 2 : Create rawMap =============
        rawMap = new RawMap(nameMap, width, height, nbrDiamond, timeRemaining);

        //============= Step 3 : get MapObject =============
        parameters.clear();
        parameters.add(new Parameters<>(nameMap, TypeParameters.IN));
        this.createCallableStatement("boulderdash.getMapObjects(?)", parameters).ifPresent(MapDAO::executeCallStatement);
        oResult = MapDAO.getResultSet();
        if(oResult.isPresent()){
            try {
                while (oResult.get().next()){
                    ObjectType type = ObjectType.valueOf(oResult.get().getObject("TypeObject").toString());
                     x = (Integer)oResult.get().getObject("CoordX");
                     y = (Integer)oResult.get().getObject("CoordY");
                    rawMap.addElement(new RawElement(type, x, y));
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return Optional.empty();
            }
        }else {
            return Optional.empty();
        }
        MapDAO.closeStatement();
        return Optional.of(rawMap);
    }

    @Override
    public void addMap(RawMap rawMap) {

        //Array of parameters
        ArrayList<Parameters> parameters = new ArrayList<>();

        //Create Map
        parameters.add(new Parameters<>(rawMap.getName(), TypeParameters.IN));
        parameters.add(new Parameters<>(rawMap.getWidth(), TypeParameters.IN));
        parameters.add(new Parameters<>(rawMap.getHeight(), TypeParameters.IN));
        parameters.add(new Parameters<>(rawMap.getNbrDiamond(), TypeParameters.IN));
        parameters.add(new Parameters<>(rawMap.getTimeRemaining(), TypeParameters.IN));
        //Execute Statement
        this.createCallableStatement("boulderdash.addMap(?,?,?,?,?)", parameters).ifPresent(MapDAO::executeCallStatement);
        //Clear parameter
        parameters.clear();

        for(RawElement element : rawMap.getElements()){
            parameters.add(new Parameters<>(rawMap.getName(), TypeParameters.IN));
            parameters.add(new Parameters<>(element.getObjectType().name(), TypeParameters.IN));
            parameters.add(new Parameters<>(element.getX(), TypeParameters.IN));
            parameters.add(new Parameters<>(element.getY(), TypeParameters.IN));
            this.createCallableStatement("boulderdash.addMapElement(?,?,?,?)", parameters).ifPresent(MapDAO::executeCallStatement);
            parameters.clear();
        }
        closeStatement();
    }

    @Override
    public void removeMap(String nameMap) {
        ArrayList<Parameters> parameters = new ArrayList<>();
        parameters.add(new Parameters<>(nameMap, TypeParameters.IN));
        this.createCallableStatement("boulderdash.removeMap(?)",parameters).ifPresent(MapDAO::executeCallStatement);

        closeStatement();
    }

    @Override
    public ArrayList<String> getMapListNames() {

        Optional<ResultSet> oResult;
        ArrayList<String> mapnames = new ArrayList<>();
        createCallableStatement("boulderdash.getMapNames()", new ArrayList<>()).ifPresent(MapDAO::executeCallStatement);
        oResult = getResultSet();
        if(oResult.isPresent()){
            try {
                while (oResult.get().next()){
                    mapnames.add((String)oResult.get().getObject("MapName"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mapnames;
    }



    //STEP 1 : Create statement
    /**
     * Create a call routine with variable parameters
     * @param sql name of routine which will be call
     * @param parameters Array(Parameters) for each parameter which compose the routine
     * @return Optional(CallableStatement) can return optional.empty() if create routine failed else return Optional(CallableStatement)
     * @see CallableStatement
     * @see Parameters
     * @see Optional
     * */
    public final Optional<CallableStatement> createCallableStatement(String sql, final ArrayList<Parameters> parameters){

        //create call routine
        final String call = "{ call " + sql + " }";
        //Parameters index of routine
        int i = 1;
        //try block
        try {
            CallableStatement callStatement = this.connection.prepareCall(call);

            for(Parameters parameter : parameters){
                switch (parameter.getTypeParameters()){
                    case IN:
                        if(parameter.getParameter() instanceof Integer){//Integer

                            callStatement.setInt(i, (Integer)parameter.getParameter());
                        }else if(parameter.getParameter() instanceof String){//String

                            callStatement.setString(i, (String)parameter.getParameter());
                        }else if(parameter.getParameter() instanceof Double){//Double

                            callStatement.setDouble(i, (Double)parameter.getParameter());
                        }else if(parameter.getParameter() instanceof Boolean){//Boolean

                            callStatement.setBoolean(i, (Boolean)parameter.getParameter());
                        }else if(parameter.getParameter() instanceof Date){//Date

                            callStatement.setDate(i, (Date)parameter.getParameter());
                        }
                        break;
                    case OUT:
                        if(parameter.getParameter() instanceof Integer){//Integer

                            callStatement.registerOutParameter(i, Types.INTEGER);
                        }else if(parameter.getParameter() instanceof String){//String

                            callStatement.registerOutParameter(i, Types.VARCHAR);
                        }else if(parameter.getParameter() instanceof Double){//Double

                            callStatement.registerOutParameter(i, Types.DOUBLE);
                        }else if(parameter.getParameter() instanceof Boolean){//Boolean

                            callStatement.registerOutParameter(i, Types.BOOLEAN);
                        }else if(parameter.getParameter() instanceof Date){//Date

                            callStatement.registerOutParameter(i, Types.DATE);
                        }
                        break;
                    case INOUT:
                        break;
                }
                i++;
            }
            return Optional.of(callStatement);
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    //STEP 3 : Execute statement
    /**
     * Allows to execute an CallableStatement
     * when execution is success the statement is closes
     * @param callableStatement CallableStatement
     * @see CallableStatement
     * */
    public static void executeCallStatement(final CallableStatement callableStatement){
        try {
            callableStatement.execute();
            statement = callableStatement;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //STEP 3 : get if possible ResultSet
    /**
     *@return Optional(ResultSet) with private static resultSet on this class
     * @see Optional
     * @see ResultSet
     * */
    public static Optional<ResultSet> getResultSet(){
        try {
            ResultSet resultSet = statement.getResultSet();
            if(resultSet != null){
                return Optional.of(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    //STEP 4 : close the statement
    /**
     * Allow to close statement
     * */
    private static void closeStatement(){
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return instance connection
     * usage for Units Test
     * */
    public final Connection getConnection() {
        return connection;
    }
}
