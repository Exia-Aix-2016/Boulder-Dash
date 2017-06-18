package com.github.ExiaAixA1.DAO;

import com.github.ExiaAixA1.model.element.Dimension;
import java.util.ArrayList;

/**
 * RawMap its a representation of an Map is not real Map
 * She will be use by Map class so can create real map.
 */
public class RawMap {
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

    /**
     * RawMap constructor
     * @param nameMap Name of this Map
     * @param dimension Dimension of this RawMap
     * */
    public RawMap(final String nameMap, final Dimension dimension){
        this.name = nameMap;
        this.dimension = dimension;
        elements = new ArrayList<>();
    }//FINISH

    //Mutateur
    /**
     * Add Element in Map Array
     * @param element RawElement
     * @see RawElement
     * */
    public void addElement(final RawElement element){
        this.elements.add(element);
    }//FINISH

    //Assesseur
    /**
     * @return name of this Map
     * */
    public String getName() {
        return name;
    }//FINISH
    /**
     * @return Dimension of this Map
     * @see Dimension
     * */
    public Dimension getDimension() {
        return dimension;
    }//FINISH
    /**
     * @return RawElement Array of this Map
     * @see RawElement
     * */
    public ArrayList<RawElement> getElements() {
        return elements;
    }//FINISH





}
