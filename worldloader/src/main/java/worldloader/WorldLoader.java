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
 *
 */
public abstract class WorldLoader {

    private static ICreateWorld world = null;

    public static Optional<ICreateWorld> getMap(final String nameMap, IMap MapDAO){
        MapDAO.getMap(nameMap).ifPresent(WorldLoader::genWorld);
        if(world == null){
            return Optional.empty();
        }else {
            return Optional.of(world);
        }

    }
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
