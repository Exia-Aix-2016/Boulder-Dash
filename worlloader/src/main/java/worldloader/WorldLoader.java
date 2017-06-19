package worldloader;

import dao.IMap;
import dao.RawElement;
import dao.RawMap;
import world.ICreateWorld;
import world.*;
import world.elements.entity.Character;

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
                    break;
                case MONSTER:
                    break;
                case DIAMOND:
                    break;
                case WALL:
                    break;
                case DIRT:
                    break;
                case ROCK:
                    break;

            }
        }

    }
}
