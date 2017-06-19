package worldloader;

import dao.IMap;
import dao.MapDAO;
import dao.RawMap;
import world.World;

import java.util.Optional;

/**
 *
 */
public abstract class WorldLoader {

    private static World world = null;

    public static Optional<World> getMap(final String nameMap, IMap MapDAO){
        MapDAO.getMap(nameMap).ifPresent(WorldLoader::genWorld);

        if(world == null){
            return Optional.empty();
        }else {
            return Optional.of(world);
        }

    }

    private static void genWorld(final RawMap rawMap){

        


    }

}
