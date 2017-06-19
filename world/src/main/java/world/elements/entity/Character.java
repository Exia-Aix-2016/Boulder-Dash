package world.elements.entity;

import world.Dimension;
import world.Position;
import world.Permeability;

public class Character extends Entity {
    private String up_sprite;
    private String down_sprite;
    private String left_sprite;
    private String right_sprite;


    public Character(Position position, Dimension dimension, String waiting_sprite, String up_sprite, String down_sprite, String left_sprite, String right_sprite, Permeability permeability){
        super(position, dimension, waiting_sprite, permeability);
        this.up_sprite = up_sprite;
        this.down_sprite = down_sprite;
        this.left_sprite = left_sprite;
        this.right_sprite = right_sprite;
    }
}