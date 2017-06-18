package dao;

import model.elements.Dimension;
import model.elements.Position;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

/**
 * MapDAO
 * CRUD with DataBase
 * @see IMap
 * @see Dao
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
    }//FINISH
    //CRUD
    /**
     * @see IMap
     * */
    @Override
    public Optional<RawMap> getMap(final String nameMap) {

        //Init attributs
        Integer width = 0, Height = 0;
        Dimension size;
        RawMap rawMap;
        ResultSet resultSet;
        ArrayList<Parameters> parameters = new ArrayList<>();


        //============= Step 1 : Get Dimension of this map =============

        parameters.add(new Parameters<>(nameMap, TypeParameters.IN));
        parameters.add(new Parameters<>(width, TypeParameters.OUT));
        parameters.add(new Parameters<>(Height, TypeParameters.OUT));
        this.createCallableStatement("boulderdash.getSizeMap(?,?,?)", parameters).ifPresent(MapDAO::executeCallStatement);

        //Create Dimension object
        try {
            size = new Dimension(statement.getInt(2), statement.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }

        //============= Step 2 : Create rawMap =============
            rawMap = new RawMap(nameMap, size);

        //============= Step 3 : get MapObject =============
        parameters.clear();
        parameters.add(new Parameters<>(nameMap, TypeParameters.IN));
        this.createCallableStatement("boulderdash.getMapObjects(?)", parameters).ifPresent(MapDAO::executeCallStatement);
        //get ResultSet
        try {
            resultSet = statement.getResultSet();
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
        //============= Step 4 : add element =============
        try {
            while (resultSet.next()){
                ObjectType type = ObjectType.valueOf(resultSet.getObject("TypeObject").toString());
                Integer x = (Integer)resultSet.getObject("CoordX");
                Integer y = (Integer)resultSet.getObject("CoordY");
                rawMap.addElement(new RawElement(type, new Position(x, y)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
        closeStatement();
        return Optional.of(rawMap);
    }//FINISH
    /**
     * @see IMap
     * */
    @Override
    public void addMap(RawMap rawMap) {

        //Array of parameters
        ArrayList<Parameters> parameters = new ArrayList<>();

        //Create Map
        parameters.add(new Parameters<>(rawMap.getName(), TypeParameters.IN));
        parameters.add(new Parameters<>(rawMap.getDimension().getWight(), TypeParameters.IN));
        parameters.add(new Parameters<>(rawMap.getDimension().getHeight(), TypeParameters.IN));
        //Execute Statement
        this.createCallableStatement("boulderdash.addMap(?,?,?)", parameters).ifPresent(MapDAO::executeCallStatement);
        //Clear parameter
        parameters.clear();

        for(RawElement element : rawMap.getElements()){
            parameters.add(new Parameters<>(rawMap.getName(), TypeParameters.IN));
            parameters.add(new Parameters<>(element.getObjectType().name(), TypeParameters.IN));
            parameters.add(new Parameters<>(element.getPosition().getX(), TypeParameters.IN));
            parameters.add(new Parameters<>(element.getPosition().getY(), TypeParameters.IN));
            this.createCallableStatement("boulderdash.addMapElement(?,?,?,?)", parameters).ifPresent(MapDAO::executeCallStatement);
            parameters.clear();
        }
        closeStatement();
    }//FINISH
    /**
     * @see IMap
     *
     * */
    @Override
    public void removeMap(String nameMap) {
        ArrayList<Parameters> parameters = new ArrayList<>();
        parameters.add(new Parameters<>(nameMap, TypeParameters.IN));
        this.createCallableStatement("boulderdash.removeMap(?)",parameters).ifPresent(MapDAO::executeCallStatement);

        closeStatement();
    }//FINISH


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
    }//FINISH

    /**
     * Allows to execute an CallableStatement
     * when execution is success the statement is closes
     * @param callableStatement CallableStatement
     * @see CallableStatement
     * @throws SQLException
     * */
    public static void executeCallStatement(final CallableStatement callableStatement){
        try {
            callableStatement.execute();
            statement = callableStatement;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//FINISH

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
     * Add Object type into dataBase.
     *call sql function boulderdash.addObjectType()
     * @return true if success or false is if failure
     * @throws SQLException
     * */
    public void addObjectType(final ObjectType objectType){
        //Array of parameters
        ArrayList<Parameters> parameters = new ArrayList<>();
        parameters.add(new Parameters<>(objectType.name(), TypeParameters.IN));
        this.createCallableStatement("boulderdash.addObjectType(?)", parameters).ifPresent(MapDAO::executeCallStatement);
    }//FINISH

    /**
     * Remove Object in ObjectType
     * call sql function boulderdash.removeObjectType()
     * @return true if success or false if failure
     * @throws SQLException
     * * */
    public void removeObjectType(final ObjectType objectType){
        //Array of parameters
        ArrayList<Parameters> parameters = new ArrayList<>();
        parameters.add(new Parameters<>(objectType.name(), TypeParameters.IN));
        this.createCallableStatement("boulderdash.removeObjectType(?)", parameters).ifPresent(MapDAO::executeCallStatement);
    }//FINISH

    /**
     * @return instance connection
     * usage for Units Test
     * */
    public final Connection getConnection() {
        return connection;
    }//FINISH
}
