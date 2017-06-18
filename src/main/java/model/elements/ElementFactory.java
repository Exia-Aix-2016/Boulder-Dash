package model.elements;

public abstract class ElementFactory {

    public static Element createCharacter(String sprite, Position position, Dimension dimension, int permeability){
        return new Character(sprite, position, dimension, permeability);
    }

    public static Element createDiamond(String sprite, Position position, Dimension dimension, int permeability){
        return new Character(sprite, position, dimension, permeability);
    }

    public static Element createDirt(String sprite, Position position, Dimension dimension, int permeability) {
        return new Character(sprite, position, dimension, permeability);
    }

    public static Element createMob(String sprite, Position position, Dimension dimension, int permeability) {
        return new Character(sprite, position, dimension, permeability);
    }

    public static Element createRock(String sprite, Position position, Dimension dimension, int permeability) {
        return new Character(sprite, position, dimension, permeability);
    }

    public static Element createWall(String sprite, Position position, Dimension dimension, int permeability) {
        return new Character(sprite, position, dimension, permeability);
    }
}
