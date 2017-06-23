package dao;



/**
 * RawElement its a representation of an Element is not real Element
 * He will be use by RawMap class so can create representation of Map.
 *
 */
public class RawElement {

    /**
     * Type of this Element.
     * @see ObjectType
     * */
    private ObjectType objectType;

    /**
     * x position
     * */
    private int x;
    /**
     * y position
     * */
    private int y;

    /**
     * Constructor of RawElement
     * @param objectType Type of this Element (DIRT, ROCK, MONSTER, etc...).
     * @param x x position
     * @param y y position
     * */
    public RawElement(final ObjectType objectType, final int x, final int y){
        this.objectType = objectType;
        this.x = x;
        this.y = y;
    }

    /**
     * @return y position
     * */
    public int getY() {
        return y;
    }
    /**
     * @return x position
     * */
    public int getX() {
        return x;
    }

    /**
     * @return Type of this Element.
     * */
    public ObjectType getObjectType() {
        return objectType;
    }
}
