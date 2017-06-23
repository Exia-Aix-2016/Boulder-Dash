package dao;

import org.junit.BeforeClass;
import org.junit.Test;
import java.sql.Connection;
import static org.junit.Assert.fail;

/**
 * Class Test DaoClass
 * Test instanciate
 * Test Connection
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
    }

    /**
     * Test Connection
     * */
    @Test
    public void TestGetConnection(){
        System.out.println("DAOTest : test connection");
        connection = dao.getConnection();
        if(connection == null){
            fail("Fail : getConnection");
        }
    }
}