package model.element;

class Element {
    private Position position;
    private Dimension dimension;

    private String sprite;
    private int permeability;


    Element (String sprite, Position position, Dimension dimension, int permeability){
        this.position = position;
        this.dimension = dimension;

        this.sprite = sprite;
        this.permeability = permeability;
    }
}
