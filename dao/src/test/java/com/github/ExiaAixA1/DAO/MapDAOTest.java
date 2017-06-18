package com.github.ExiaAixA1.DAO;

import com.github.ExiaAixA1.model.element.Dimension;
import com.github.ExiaAixA1.model.element.Position;
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
     * Instance of object which will be test
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
     * Test insert ObjectType
     * */
    @Test
    public void InsertObjectTypeTest(){
    }//TODO

    /**
     * Test remove ObjectType
     * */
    @Test
    public void removeObjectTypeTest(){
    }//TODO

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
