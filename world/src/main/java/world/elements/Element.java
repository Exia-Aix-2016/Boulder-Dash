package model.elements;

public abstract class Element {
    private Position position;
    private Dimension dimension;

    private String sprite;
    private Permeability permeability;


    Element (final String sprite, Position position, final Dimension dimension, Permeability permeability){
        this.position = position;
        this.dimension = dimension;

        this.sprite = sprite;
        this.permeability = permeability;
    }

    public Position getPosition() {
        return position;
    }
}
