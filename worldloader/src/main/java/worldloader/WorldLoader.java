package worldloader;

import dao.IMap;
import dao.RawElement;
import dao.RawMap;
import world.Dimension;
import world.ICreateWorld;
import world.Position;
import world.World;

import java.util.Optional;

/**
 * WorldLoader will can use IMap (DAO) to load a RawMap (which a sql representation of a world)
 * @see dao
 *
 */
public abstract class WorldLoader {

    private static ICreateWorld world = null;

    /**
     * Allow to get map with her name
     * @param nameMap name of map you can load
     * @param MapDAO DAO which allow to search the map in database
     * @return a Optional(ICreateWorld interface between WorldLoader and World)
     * @see ICreateWorld
     * @see world
     * @see Optional
     * */
    public static Optional<ICreateWorld> getMap(final String nameMap, IMap MapDAO){
        MapDAO.getMap(nameMap).ifPresent(WorldLoader::genWorld);
        if(world == null){
            return Optional.empty();
        }else {
            return Optional.of(world);
        }

    }

    /**
     * It's used by getWorld to create the world
     * @param rawMap its a representation of database Map
     * */
    private static void genWorld(final RawMap rawMap){

        Dimension dimension = new Dimension(rawMap.getWidth(), rawMap.getHeight());

        world = new World(rawMap.getName(), dimension, rawMap.getNbrDiamond(), rawMap.getTimeRemaining());

        for (RawElement element : rawMap.getElements()){
            switch (element.getObjectType()){
                case CHARACTER:
                    world.addEntity(FactoryElement.getNewCharacter(
                            new Position(element.getX(), element.getY()),
                            new Dimension(16, 16)));
                    break;
                case MONSTER:
                    world.addEntity(FactoryElement.getNewMonster(
                            new Position(element.getX(), element.getY()),
                            new Dimension(16, 16)));
                    break;
                case DIAMOND:
                    world.addEntity(FactoryElement.getNewDiamond(
                            new Position(element.getX(), element.getY()),
                            new Dimension(16, 16)));
                    break;
                case ROCK:
                    world.addEntity(FactoryElement.getNewRock(
                            new Position(element.getX(), element.getY()),
                            new Dimension(16, 16)));
                    break;
                case WALL:
                    world.addBlock(FactoryElement.getNewWall(
                            new Position(element.getX(), element.getY()),
                            new Dimension(16, 16)));
                    break;
                case DIRT:
                    world.addBlock(FactoryElement.getNewDirt(
                            new Position(element.getX(), element.getY()),
                            new Dimension(16, 16)));
                    break;
            }
        }
    }
}
