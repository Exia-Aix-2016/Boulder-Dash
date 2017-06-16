package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * MapDAO
 * CRUD with DataBase
 */
public class MapDAO implements IMap {

    /**
     * Connection dataBase
     * */
    private Dao dao;
    private PreparedStatement statement;

    /**
     * Constructor
     * initialize dao
     * */
   public MapDAO(){

       this.dao = Dao.getInstance();

    }


    //CRUD
    @Override
    public RawMap getMap(int idMap) {
        return null;
    }

    @Override
    public void addMap(RawMap rawMap) {

    }


    /**
     * Add Object type into dataBase.
     *
     * */
    public void addObjectType(final ObjectType objectType){
        
    }


    /**
     * Close Statement DAO
     * */
    public boolean closeStatement(){
        try {
            this.statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Assesseur

    /**
     * @return dao instance
     * */
    public Dao getDao() {
        return dao;
    }

    /**
     * @return statement instance
     * */
    public Statement getStatement() {
        return statement;
    }
}
