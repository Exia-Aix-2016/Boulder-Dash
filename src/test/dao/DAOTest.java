package dao;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.fail;

/**
 * Class Test DaoClass
 * Test instanciate
 * Test Connection
 * Test Close Connection
 * */
public class DAOTest {

    /**
     * Instance of dao
     * */
    private static Dao dao = null;
    /**
     * Instance of connection
     * */
    private static Connection connection = null;

    /**
     * Instanciate Dao
     * Test Instanciate
     * */
    @BeforeClass
    public static void initDaoTest(){

        dao = Dao.getInstance();
        if(dao == null){
            fail("Fail : instanciate dao");
        }
    }//FINISH

    /**
     * Test Connection
     * */
    @Test
    public void TestGetConnection(){
        connection = dao.getConnection();
        if(connection == null){
            fail("Fail : getConnection");
        }
    }//FINISH
    /**
     * Test Close Connection
     * */
    @AfterClass
    public static void CloseConnection(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                fail("Fail : Close DataBase Connection !");
            }
        }

    }//FINISH
}