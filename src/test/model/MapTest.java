package model;

import dao.ObjectType;
import dao.RawElement;
import dao.RawMap;
import model.elements.Dimension;
import model.elements.Position;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.fail;

/**
 * Created by Mandel on 18/06/2017.
 */
public class MapTest {

    private static Map map;

    @BeforeClass
    public static void initMapTest(){
        map = new Map("test", new Dimension(10, 10));
    }

    @Test
    public void convertToRawMapTest(){
        Map.convertMapToRawMap(map);
    }
    @Test
    public void convertRawMapToMapTest(){
        RawMap rMap = new RawMap("test", new Dimension(10, 10));
        rMap.addElement(new RawElement(ObjectType.CHARACTER, new Position(10, 2)));

        Map.convertRawMapToMap(rMap);
    }
}
