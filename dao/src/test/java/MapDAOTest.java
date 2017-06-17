import DAO.MapDAO;
import DAO.ObjectType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;


/**
 * Created by Mandel on 16/06/2017.
 */
public class MapDAOTest {

    private static MapDAO mapDAO;

    @BeforeClass
    public static void initMapDAOTest(){

        mapDAO = new MapDAO();
        if(mapDAO.getConnection() == null){
         fail("Fail : connection");
        }
    }


    public void InsertObjectTypeTest(){

        if(!mapDAO.addObjectType(ObjectType.DIRT)){
            fail("Fail : insert ObjectType");
        }
    }

    public void removeObjectTypeTest(){
        if(!mapDAO.removeObjectType(ObjectType.DIRT)){
            fail("Fail : insert ObjectType");
        }
    }

    @AfterClass
    public static void closeConnection(){
        try {
            mapDAO.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Erreur close connection");
        }
    }
}
