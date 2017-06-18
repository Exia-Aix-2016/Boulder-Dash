package dao;

import model.elements.Dimension;
import model.elements.Position;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.fail;


/**
 * TESTS CLass
 * TESTS FOR MapDAO Class
 * */
public class MapDAOTest {

    /**
     * Instance of element which will be test
     * */
    private static MapDAO mapDAO;

    /**
     * Instanciate mapDAO
     * */
    @BeforeClass
    public static void initMapDAOTest(){
        mapDAO = new MapDAO();
        if(mapDAO.getConnection() == null){
         fail("Fail : connection");
        }
    }//FINISH

    /**
     * Test remove ObjectType
     * */
    @Test
    public void removeObjectTypeTest(){
        mapDAO.removeObjectType(ObjectType.DIRT);
    }//FINISH
    /**
     * Test insert ObjectType
     * */
    @Test
    public void InsertObjectTypeTest(){
        mapDAO.addObjectType(ObjectType.DIRT);
    }//FINISH

    /**
     * Test create MAp
     * */
    @Test
    public void createMapTest(){
        RawMap map = new RawMap("test", new Dimension(10, 10));
        map.addElement(new RawElement(ObjectType.WALL, new Position(0, 0)));
        map.addElement(new RawElement(ObjectType.WALL, new Position(1, 0)));

        mapDAO.addMap(map);
    }//FINISH
    @Test
    public void removeMap(){
        mapDAO.removeMap("test");
    }//FINISH
    /**
     * Close connection
     * */
    @AfterClass
    public static void closeConnection(){
        try {
            mapDAO.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Erreur close connection");
        }
    }//FINISH
}
