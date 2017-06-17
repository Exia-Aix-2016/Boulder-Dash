package model.element;

public abstract class ElementFactory {

    Element createCharacter(String sprite, Position position, Dimension dimension, int permeability){
        return new Character(sprite, position, dimension, permeability);
    }

    Element createDiamond(String sprite, Position position, Dimension dimension, int permeability){
        return new Character(sprite, position, dimension, permeability);
    }

    Element createDirt(String sprite, Position position, Dimension dimension, int permeability) {
        return new Character(sprite, position, dimension, permeability);
    }

    Element createMob(String sprite, Position position, Dimension dimension, int permeability) {
        return new Character(sprite, position, dimension, permeability);
    }

    Element createRock(String sprite, Position position, Dimension dimension, int permeability) {
        return new Character(sprite, position, dimension, permeability);
    }

    Element createWall(String sprite, Position position, Dimension dimension, int permeability) {
        return new Character(sprite, position, dimension, permeability);
    }
}
