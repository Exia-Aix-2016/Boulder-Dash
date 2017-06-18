package model;

import dao.MapDAO;
import dao.ObjectType;
import dao.RawElement;
import dao.RawMap;
import model.elements.*;

import java.util.ArrayList;
/**
 *
 * */
public class Map {
    private String name;
    private Dimension dimension;
    private ArrayList<Element> elements;

    /**
     *Constructor Map
     * @param dimension set Dimension
     * @param name set name
     * */
    public Map(final String name, final Dimension dimension){
        this.name = name;
        this.dimension = dimension;

        this.elements = new ArrayList<>();
    }

    public void addElement(Element element){
        this.getElements().add(element);
    }
    //Assesseur
    /**
     * set name
     * @param name nameMap
     * */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *set dimensions
     * @param dimension Object Dimension
     * @see Dimension
     * */
    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    //Mutateur
    /**
     * @return Dimension of this map
     * @see Dimension
     * */
    public Dimension getDimension() {
        return dimension;
    }
    /**
     * @return get name of this map
     * */
    public final String getName() {
        return name;
    }
    /**
     * @return the elements which compose this map
     * @see Element
     * */
    public ArrayList<Element> getElements() {
        return elements;
    }


    //Convert map -> RawMap
    /**
     * Allow to convert Map to RawMap
     * */
    public static RawMap convertMapToRawMap(Map map){
        RawMap rwMap = new RawMap(map.getName(), map.getDimension());

        for(Element element : map.getElements()){
            String elemType = element.getClass().getSimpleName().toUpperCase();
            rwMap.addElement(new RawElement(ObjectType.valueOf(elemType), element.getPosition()));
        }
        return rwMap;
    }
    //Convert RawMap -> Map
    /**
     * Allow to convert RawMap to Map
     * */
    public static Map convertRawMapToMap(final RawMap rwMap){
        Map map = new Map(rwMap.getName(), rwMap.getDimension());

        for(RawElement element : rwMap.getElements()) {
            switch (element.getObjectType()){
                case ROCK:
                    map.addElement(ElementFactory.createRock("", element.getPosition(), new Dimension(1,1), Permeability.MOVEABLE));
                    break;
                case DIRT:
                    map.addElement(ElementFactory.createDirt("", element.getPosition(), new Dimension(1,1), Permeability.REMOVABLE));
                    break;
                case WALL:
                    map.addElement(ElementFactory.createWall("", element.getPosition(), new Dimension(1,1), Permeability.BLOCKING));
                    break;
                case DIAMOND:
                    map.addElement(ElementFactory.createDiamond("", element.getPosition(), new Dimension(1,1), Permeability.MOVEABLE));
                    break;
                case MONSTER:
                    map.addElement(ElementFactory.createMob("", element.getPosition(), new Dimension(1,1), Permeability.MOVEABLE));
                    break;
                case CHARACTER:
                    map.addElement(ElementFactory.createCharacter("", element.getPosition(), new Dimension(1,1), Permeability.MOVEABLE));
                    break;
            }
        }
        return map;
    }
}
