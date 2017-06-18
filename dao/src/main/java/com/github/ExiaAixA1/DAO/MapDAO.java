package com.github.ExiaAixA1.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import com.github.ExiaAixA1.DAO.*;

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

    /**
     * Constructor
     * initialize dao
     * */
   public MapDAO(){
       this.connection = Dao.getInstance().getConnection();
    }//FINISH


    //CRUD
    /**
     * @see IMap
     * */
    @Override
    public RawMap getMap(final String nameMap) {
        return null;
    }//TODO

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

        for(RawElement element : rawMap.getElements()){
            parameters.add(rawMap.getName());
            parameters.add(element.getObjectType().name());
            parameters.add(element.getPosition().getX());
            parameters.add(element.getPosition().getY());
            this.createCallableStatement("boulderdash.addMapElement(?,?,?,?)", parameters).ifPresent(MapDAO::executeCallStatement);
            parameters.clear();
        }
    }//FINISH
    /**
     * @see IMap
     *
     * */
    @Override
    public void removeMap(String nameMap) {
        ArrayList<Object> parameters = new ArrayList<>();
        parameters.add(nameMap);
        this.createCallableStatement("boulderdash.removeMap(?)",parameters).ifPresent(MapDAO::executeCallStatement);
    }//FINISH


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
                if(obj instanceof Integer){//Integer
                    callStatement.setInt(i, (Integer)obj);
                }else if(obj instanceof String){//String
                    callStatement.setString(i, (String)obj);
                }else if(obj instanceof Double){//Double
                    callStatement.setDouble(i, (Double)obj);
                }else if(obj instanceof Boolean){//Boolean
                    callStatement.setBoolean(i, (Boolean)obj);
                }else if(obj instanceof Date){//Date
                    callStatement.setDate(i, (Date)obj);
                }
                i++;
            }
            return Optional.of(callStatement);
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }//FINISH TO OPTIMIZE

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
            callableStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//FINISH
    /**
     * Add Object type into dataBase.
     *call sql function boulderdash.addObjectType()
     * @return true if success or false is if failure
     * @throws SQLException
     * */
    public void addObjectType(final ObjectType objectType){
        //Array of parameters
        ArrayList<Object> parameters = new ArrayList<>();
        parameters.add(objectType.name());
        this.createCallableStatement("boulderdash.addObjectType(?)", parameters).ifPresent(MapDAO::executeCallStatement);
    }//FINISH TO TEST

    /**
     * Remove Object in ObjectType
     * call sql function boulderdash.removeObjectType()
     * @return true if success or false if failure
     * @throws SQLException
     * * */
    public void removeObjectType(final ObjectType objectType){
        //Array of parameters
        ArrayList<Object> parameters = new ArrayList<>();
        parameters.add(objectType.name());
        this.createCallableStatement("boulderdash.removeObjectType(?)", parameters).ifPresent(MapDAO::executeCallStatement);
    }//FINISH TO TEST

    /**
     * @return instance connection
     * usage for Units Test
     * */
    public final Connection getConnection() {
        return connection;
    }//FINISH
}
