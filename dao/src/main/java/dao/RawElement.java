package dao;


import model.elements.Position;

/**
 * RawElement its a representation of an Element is not real Element
 * He will be use by RawMap class so can create representation of Map.
 */
public class RawElement {

    /**
     * Type of this Element.
     * @see ObjectType
     * */
    private ObjectType objectType;

    /**
     * Position of this Element.
     * @see Position
     * */
    private Position position;

    /**
     * Constructor of RawElement
     * @param objectType Type of this Element (DIRT, ROCK, MONSTER, etc...).
     * @param position Position of this Element.
     * @see Position
     * */
    public RawElement(final ObjectType objectType, final Position position){
        this.objectType = objectType;
        this.position = position;
    }//FINISH

    /**
     * @return Position.
     * @see Position
     * */
    public Position getPosition() {
        return position;
    }//FINISH

    /**
     * @return Type of this Element.
     * */
    public ObjectType getObjectType() {
        return objectType;
    }//FINISH
}
