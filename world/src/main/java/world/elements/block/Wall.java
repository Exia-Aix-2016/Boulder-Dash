package world.elements.block;

import world.Position;
import world.Permeability;
import world.elements.SpriteManager;

import java.awt.*;

public class Wall extends Block{

    public Wall(Position position, Dimension dimension){
        super(position, dimension, new SpriteManager(
                "Wall.png"
        ));
    }
}