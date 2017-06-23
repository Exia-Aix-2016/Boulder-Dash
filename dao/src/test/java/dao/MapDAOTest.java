package dao;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import java.sql.SQLException;
import static org.junit.Assert.fail;

/**
 * Test Create map Method
 * TEST Close connection
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
    }

    /**
     * Test remove ObjectType
     * */
    private void removeObjectTypeTest(ObjectType objectType){
        System.out.println("MapDAOTest : removeObjectTypeTest");
        mapDAO.removeObjectType(objectType);
    }

    /**
     * Test insert ObjectType
     * */
    private void insertObjectTypeTest(ObjectType objectType){
        System.out.println("MapDAOTest : InsertObjectTypeTest");
        mapDAO.addObjectType(objectType);
    }
    /**
     * Test create MAp
     * */
    private void createMapTest(){
        System.out.println("MapDAOTest : Create Map");
        RawMap map = new RawMap("test", 10, 10, 150, 1500);
        map.addElement(new RawElement(ObjectType.WALL, 10, 10));
        map.addElement(new RawElement(ObjectType.WALL, 5, 5));
        map.addElement(new RawElement(ObjectType.DIRT, 1, 1));
        mapDAO.addMap(map);
    }

    /**
     * Test GetMap
     * */
    private void getMapTest(){
        System.out.println("MapDAOTest : get Map");
        if(!mapDAO.getMap("test").isPresent()){
            fail("Fail : getMap()");
        }
    }

    /**
     * Test Remove Map
     * */
    private void removeMapTest(){
        System.out.println("MapDAOTest : remove Map");
        mapDAO.removeMap("test");
    }

    /**
     * Test get listMap
     * */
    private void testGetMapNames(){

        for(String name : mapDAO.getMapListNames()){
            System.out.println(name);
        }
    }

    /**
     * Order the test map
     * */
    @Test
    public void testInteracMap(){
        this.createMapTest();
        this.getMapTest();
        this.testGetMapNames();
        this.removeMapTest();

    }

    /**
     * Order the test ObjectType
     * */
    @Test
    public void testInteractObjectType(){
        this.insertObjectTypeTest(ObjectType.TEST);
        this.removeObjectTypeTest(ObjectType.TEST);
    }


    /**
     * Close connection
     * */
    @AfterClass
    public static void closeConnection(){
        System.out.println("MapDAOTest : Close connection");
        try {
            mapDAO.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Erreur close connection");
        }
    }
}
