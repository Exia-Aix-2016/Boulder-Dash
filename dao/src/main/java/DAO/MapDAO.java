package DAO;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;

/**
 * MapDAO
 * CRUD with DataBase
 */
public class MapDAO implements IMap {

    /**
     * Connection dataBase
     * */
    private Connection connection;
    private CallableStatement CALLstatement;

    /**
     * Constructor
     * initialize dao
     * */
   public MapDAO(){
       this.connection = Dao.getInstance().getConnection();
    }


    //CRUD
    /**
     * @see IMap
     * */
    @Override
    public RawMap getMap(int idMap) {
        return null;
    }
    /**
     * @see IMap
     * */
    @Override
    public void addMap(RawMap rawMap) {

        //Array of parameters
        ArrayList<Object> parameters = new ArrayList<>();

        //Create Map
        parameters.add(rawMap.getName());
        parameters.add(rawMap.getDimension().getWight());
        parameters.add(rawMap.getDimension().getHeight());
        //Execute Statement
        this.createCallableStatement("boulderdash.addMap(?,?,?)", parameters).ifPresent(MapDAO::executeCallStatement);
        //Clear parameter
        parameters.clear();

    }
    /**
     * Allows to execute an CallableStatement
     * @param callableStatement CallableStatement
     * @see CallableStatement
     * */
    public static void executeCallStatement(final CallableStatement callableStatement){
        try {
            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create a call routine with variable parameters
     * @param sql name of routine which will be call
     * @param parameters Array(Object) for each parameter which compose the routine
     * @return Optional(CallableStatement) can return optional.empty() if create routine failed else return Optional(CallableStatement)
     * @see CallableStatement
     * @see Object
     * @see Optional
     * */
    public final Optional<CallableStatement> createCallableStatement(String sql, final ArrayList<Object> parameters){

        //create call routine
        final String call = "{ call " + sql + " }";
        //Parameters index of routine
        int i = 1;
        //try block
        try {
            CallableStatement callStatement = this.connection.prepareCall(call);

            for(Object obj : parameters){
                if(obj instanceof Integer){

                    callStatement.setInt(i, (Integer)obj);

                }else if(obj instanceof String){

                    callStatement.setString(i, (String)obj);
                }
                i++;
            }

            return Optional.of(callStatement);
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();

        }
    }
    /**
     * @see IMap
     * */
    @Override
    public void removeMap(String nameMap) {

    }
    /**
     * @see IMap
     * */
    @Override
    public void removeMap(int indexMap) {

    }

    /**
     * Add Object type into dataBase.
     *call sql function boulderdash.addObjectType()
     * @return true if success or false is if failure
     * */
    public boolean addObjectType(final ObjectType objectType){
        final String oTypeString = objectType.name();
        try{
            this.CALLstatement =  connection.prepareCall("{ call boulderdash.addObjectType(?)}");
            this.CALLstatement.setString(1, oTypeString);
            this.CALLstatement.execute();
            this.closeStatement();
            return true;

        }catch (Exception e){

            e.getStackTrace();
            return false;
        }
    }

    /**
     * Remove Object in ObjectType
     * call sql function boulderdash.removeObjectType()
     * @return true if success or false if failure
     * * */
    public boolean removeObjectType(final ObjectType objectType){

        final String oTypeString = objectType.name();
        try{
            this.CALLstatement =  connection.prepareCall("{ call boulderdash.removeObjectType(?)}");
            this.CALLstatement.setString(1, oTypeString);
            this.CALLstatement.execute();
            this.closeStatement();
            return true;

        }catch (Exception e){

            e.getStackTrace();
            return false;
        }
    }


    /**
     * Close Statement DAO
     * */
    public void closeStatement(){
        try {
            this.CALLstatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Assesseur
    /**
     * @return statement instance
     * */
    public Statement getStatement() {
        return this.CALLstatement;
    }

    /**
     * @return instance connection
     * usage for Units Test
     * */
    public final Connection getConnection() {
        return connection;
    }
}
