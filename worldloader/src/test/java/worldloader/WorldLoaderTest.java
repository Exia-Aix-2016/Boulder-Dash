package worldloader;

import dao.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.fail;


/**
 * TestClass WorldLoarder
 */
public class WorldLoaderTest {

    private static IMap mapDao;

    /**
     * Instanciate mapDao
     * */
    @BeforeClass
    public static void initWorldLoader(){
         mapDao = new MapDAO();
    }

    /**
     * Test getMap() method.
     * */
    @Test
    public void getMapTest(){
        System.out.println("WorldLoader Test : getMap()");
        RawMap map = new RawMap("test", 10, 10, 150, 1500);
        map.addElement(new RawElement(ObjectType.WALL, 10, 10));
        map.addElement(new RawElement(ObjectType.WALL, 5, 5));
        map.addElement(new RawElement(ObjectType.DIRT, 1, 1));
        mapDao.addMap(map);
        try {
            WorldLoader.getMap("test", mapDao, new Dimension(800, 800));
        } catch (Exception e) {
            e.printStackTrace();
            fail("Fail WorldLoader : getMap()");
        }
        mapDao.removeMap("test");
    }
}
