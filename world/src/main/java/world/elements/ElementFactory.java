package world.elements;

import world.Dimension;
import world.Position;

public abstract class ElementFactory {

    public static Element createCharacter(final String sprite, Position position, final Dimension dimension, Permeability permeability){
        return new Character(sprite, position, dimension, permeability);
    }

    public static Element createDiamond(final String sprite, Position position, final Dimension dimension, Permeability permeability){
        return new Diamond(sprite, position, dimension, permeability);
    }

    public static Element createDirt(final String sprite, Position position, final Dimension dimension, Permeability permeability) {
        return new Dirt(sprite, position, dimension, permeability);
    }

    public static Element createMob(final String sprite, Position position, final Dimension dimension, Permeability permeability) {
        return new Mob(sprite, position, dimension, permeability);
    }

    public static Element createRock(final String sprite, Position position, final Dimension dimension, Permeability permeability) {
        return new Rock(sprite, position, dimension, permeability);
    }

    public static Element createWall(final String sprite, Position position, final Dimension dimension, Permeability permeability) {
        return new Wall(sprite, position, dimension, permeability);
    }
}
