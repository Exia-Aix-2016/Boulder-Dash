package DAO;

import model.element.Dimension;
import java.util.ArrayList;

/**
 * RawMap its a representation of an Map is not real Map
 * She will be use by Map class so can create real map.
 */
public class RawMap {
    /**
     * id of Map
     * */
    private int id;
    /**
     * name of Map
     * */
    private String name;
    /**
     *Dimension of Map
     * @see Dimension
     * */
    private Dimension dimension;
    /**
     * Element which compose the Map
     * @see RawElement
     * */
    private ArrayList<RawElement> elements;

    public RawMap(final int idMap, final String nameMap, final Dimension dimension){
        this.id = idMap;
        this.name = nameMap;
        this.dimension = dimension;
        elements = new ArrayList<>();
    }

    //Mutateur
    public void addElement(final RawElement element){
        this.elements.add(element);
    }

    //Assesseur
    /**
     * @return id of this Map
     * */
    public int getId() {
        return id;
    }
    /**
     * @return name of this Map
     * */
    public String getName() {
        return name;
    }
    /**
     * @return Dimension of this Map
     * @see Dimension
     * */
    public Dimension getDimension() {
        return dimension;
    }
    /**
     * @return RawElement Array of this Map
     * @see RawElement
     * */
    public ArrayList<RawElement> getElements() {
        return elements;
    }





}
