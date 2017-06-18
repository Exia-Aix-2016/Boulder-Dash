package com.github.ExiaAixA1.model.element;

public class Movable extends Element implements IMove{

    Movable(String sprite, Position position, Dimension dimension, int permeability){
        super(sprite, position, dimension, permeability);
    }
}
