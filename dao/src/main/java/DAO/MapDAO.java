package DAO;

import java.sql.*;

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
     * @return true if success or false is if failure
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
