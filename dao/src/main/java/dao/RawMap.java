package dao;


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
     * width
     * */
    private int width;
    /**
     * height
     * */
    private int height;
    /**
     * number of diamond
     * */
    private int nbrDiamond;
    /**
     * time remaining
     * */
    private int timeRemaining;
    /**
     * Element which compose the Map
     * @see RawElement
     * */
    private ArrayList<RawElement> elements;

    /**
     * RawMap constructor
     * @param nameMap Name of this Map
     * @param height height
     * @param width width
     * @param nbrDiamond number of diamond in the map
     * @param timeRemaining time remaining
     * */
    public RawMap(final String nameMap, final int width, final int height, final int nbrDiamond, final int timeRemaining){
        this.name = nameMap;
        this.width = width;
        this.height = height;
        this.nbrDiamond = nbrDiamond;
        this.timeRemaining = timeRemaining;
        elements = new ArrayList<>();
    }

    //Mutateur
    /**
     * Add Element in Map Array
     * @param element RawElement
     * @see RawElement
     * */
    public void addElement(final RawElement element){
        this.elements.add(element);
    }

    //Assesseur

    /**
     * @return width
     * */
    public int getWidth() {
        return width;
    }
    /**
     * @return Height
     * */
    public int getHeight() {
        return height;
    }
    /**
     * @return number of diamonds
     * */
    public int getNbrDiamond() {
        return nbrDiamond;
    }
    /**
     * @return time remaining
     * */
    public int getTimeRemaining() {
        return timeRemaining;
    }

    /**
     * @return name of this Map
     * */
    public String getName() {
        return name;
    }

    /**
     * @return RawElement Array of this Map
     * @see RawElement
     * */
    public ArrayList<RawElement> getElements() {
        return elements;
    }

}
