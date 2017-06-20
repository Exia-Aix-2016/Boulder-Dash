package worldloader;

import dao.IMap;
import dao.RawElement;
import dao.RawMap;
import world.ICreateWorld;
import world.Position;
import world.World;

import java.awt.*;
import java.util.Optional;

/**
 * WorldLoader will can use IMap (DAO) to load a RawMap (which a sql representation of a world)
 * @see dao
 *
 */
public abstract class WorldLoader {

    /**
     * Allow to get map with her name
     * @param nameMap name of map you can load
     * @param MapDAO DAO which allow to search the map in database
     * @return a Optional(ICreateWorld interface between WorldLoader and World)
     * @see ICreateWorld
     * @see world
     * @see Optional
     * */
    public static World getMap(final String nameMap, IMap MapDAO, Dimension screenSize) throws Exception{

        Optional<RawMap> rawMapO = MapDAO.getMap(nameMap);

        if (rawMapO.isPresent()){
            RawMap rawMap = rawMapO.get();

            Dimension dimension = new Dimension(rawMap.getWidth(), rawMap.getHeight());

            int elementSize = screenSize.width / dimension.width;

            Dimension elementDimension = new Dimension(elementSize, elementSize);

            ICreateWorld world = new World(rawMap.getName(), dimension, rawMap.getNbrDiamond(), rawMap.getTimeRemaining());

            for (RawElement element : rawMap.getElements()){
                switch (element.getObjectType()){
                    case CHARACTER:
                        world.addEntity(FactoryElement.getNewCharacter(
                                new Position(element.getX() * elementSize, element.getY() * elementSize),
                                new Dimension(elementDimension)));
                        break;
                    case MONSTER:
                        world.addEntity(FactoryElement.getNewMonster(
                                new Position(element.getX() * elementSize, element.getY() * elementSize),
                                new Dimension(elementDimension)));
                        break;
                    case DIAMOND:
                        world.addEntity(FactoryElement.getNewDiamond(
                                new Position(element.getX() * elementSize, element.getY() * elementSize),
                                new Dimension(elementDimension)));
                        break;
                    case ROCK:
                        world.addEntity(FactoryElement.getNewRock(
                                new Position(element.getX() * elementSize, element.getY() * elementSize),
                                new Dimension(elementDimension)));
                        break;
                    case WALL:
                        world.addBlock(FactoryElement.getNewWall(
                                new Position(element.getX() * elementSize, element.getY() * elementSize),
                                new Dimension(elementDimension)));
                        break;
                    case DIRT:
                        world.addBlock(FactoryElement.getNewDirt(
                                new Position(element.getX() * elementSize, element.getY() * elementSize),
                                new Dimension(elementDimension)));
                        break;
                }
            }
            return (World) world;
        } else {
            throw new Exception("Error of map loading");
        }
    }
}
