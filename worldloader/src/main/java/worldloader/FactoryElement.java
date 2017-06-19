package worldloader;

import world.Dimension;
import world.Permeability;
import world.Position;
import world.elements.block.Dirt;
import world.elements.block.Exit;
import world.elements.block.Wall;
import world.elements.entity.Diamond;
import world.elements.entity.Monster;
import world.elements.entity.Rock;
import world.elements.entity.Character;
/**
 * Created by Mandel on 20/06/2017.
 */
public abstract class FactoryElement {

    public  static Dirt getNewDirt(Position position, Dimension dimension){
        return new Dirt(position, dimension);
    }
    public static Exit getNewExit(Position position, Dimension dimension){
        return new Exit(position, dimension);
    }
    public static Wall getNewWall(Position position, Dimension dimension){
        return new Wall(position, dimension);
    }
    public static Character getNewCharacter(Position position, Dimension dimension){
        return new Character(position, dimension);
    }
    public static Diamond getNewDiamond(Position position, Dimension dimension){
        return new Diamond(position, dimension);
    }
    public static Monster getNewMonster(Position position, Dimension dimension){
        return new Monster(position, dimension);
    }
    public static Rock getNewRock(Position position, Dimension dimension){
        return new Rock(position, dimension);
    }








}
