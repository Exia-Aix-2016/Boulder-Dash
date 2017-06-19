package dao;

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
    public void removeObjectTypeTest(ObjectType objectType){
        System.out.println("MapDAOTest : removeObjectTypeTest");
        mapDAO.removeObjectType(objectType);
    }//FINISH

    /**
     * Test insert ObjectType
     * */
    public void insertObjectTypeTest(ObjectType objectType){
        System.out.println("MapDAOTest : InsertObjectTypeTest");
        mapDAO.addObjectType(objectType);
    }//FINISH
    /**
     * Test create MAp
     * */
    public void createMapTest(){
        System.out.println("MapDAOTest : Create Map");
        RawMap map = new RawMap("test", 10, 10, 150, 1500);
        map.addElement(new RawElement(ObjectType.WALL, 10, 10));
        map.addElement(new RawElement(ObjectType.WALL, 5, 5));
        map.addElement(new RawElement(ObjectType.DIRT, 1, 1));
        mapDAO.addMap(map);
    }//FINISH

    /**
     * Test GetMap
     * */
    public void getMapTest(){
        System.out.println("MapDAOTest : get Map");
        if(!mapDAO.getMap("test").isPresent()){
            fail("Fail : getMap()");
        }
    }//FINISH

    /**
     * Test Remove Map
     * */
    public void removeMapTest(){
        System.out.println("MapDAOTest : remove Map");
        mapDAO.removeMap("test");
    }//FINISH
    /**
     * Order the test map
     * */
    @Test
    public void testInteracMap(){
        this.createMapTest();
        this.getMapTest();
        this.removeMapTest();
    }
    @Test
    public void testInteractObjectType(){
        this.insertObjectTypeTest(ObjectType.TEST);
        this.removeObjectTypeTest(ObjectType.TEST);
    }

    @Test
    public void testGetMapNames(){

        for(String name : mapDAO.getMapListNames()){
            System.out.println(name);
        }
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
    }//FINISH
}
