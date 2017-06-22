package worldloader;

import world.Position;
import world.elements.block.Dirt;
import world.elements.block.Exit;
import world.elements.block.Wall;
import world.elements.entity.Character;
import world.elements.entity.Diamond;
import world.elements.entity.Monster;
import world.elements.entity.Rock;

import java.awt.*;

/**
 * Factory Element use to create Element which will compose the world.
 */
public abstract class FactoryElement {

    /**
     * Create new Dirt Element
     * @param dimension Dimension of this new Element
     * @param position Positions of this new Element
     * @return new Dirt
     * @see world.elements.Elements
     * @see Dirt
     * @see Position
     * @see Dimension
     * */
    public static Dirt getNewDirt(Position position, Dimension dimension){
        return new Dirt(position, dimension);
    }

    /**
     * Create new Exit Element
     * @param dimension Dimension of this new Element
     * @param position Positions of this new Element
     * @return new Exit
     * @see world.elements.Elements
     * @see Exit
     * @see Position
     * @see Dimension
     * */
    public static Exit getNewExit(Position position, Dimension dimension){
        return new Exit(position, dimension);
    }

    /**
     * Create new Wall Element
     * @param dimension Dimension of this new Element
     * @param position Positions of this new Element
     * @return new Wall
     * @see world.elements.Elements
     * @see Position
     * @see Position
     * @see Dimension
     * */
    public static Wall getNewWall(Position position, Dimension dimension){
        return new Wall(position, dimension);
    }

    /**
     * Create Character Wall Element
     * @param dimension Dimension of this new Element
     * @param position Positions of this new Element
     * @return new Character
     * @see world.elements.Elements
     * @see Character
     * @see Position
     * @see Dimension
     * */
    public static Character getNewCharacter(Position position, Dimension dimension){
        return new Character(position, dimension);
    }

    /**
     * Create Diamond Wall Element
     * @param dimension Dimension of this new Element
     * @param position Positions of this new Element
     * @return new Diamond
     * @see world.elements.Elements
     * @see Diamond
     * @see Position
     * @see Dimension
     * */
    public static Diamond getNewDiamond(Position position, Dimension dimension){
        return new Diamond(position, dimension);
    }

    /**
     * Create Diamond Wall Element
     * @param dimension Dimension of this new Element
     * @param position Positions of this new Element
     * @return new Diamond
     * @see world.elements.Elements
     * @see Monster
     * @see Position
     * @see Dimension
     * */
    public static Monster getNewMonster(Position position, Dimension dimension){
        return new Monster(position, dimension);
    }

    /**
     * Create Rock Wall Element
     * @param dimension Dimension of this new Element
     * @param position Positions of this new Element
     * @return new Rock
     * @see world.elements.Elements
     * @see Rock
     * @see Position
     * @see Dimension
     * */
    public static Rock getNewRock(Position position, Dimension dimension){
        return new Rock(position, dimension);
    }








}
