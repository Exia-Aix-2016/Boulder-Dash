package world;

import world.block.Block;
import world.entity.Entity;

/**
 *
 */
public interface ICreateWorld {

    /**
     *
     * */
    void addEntity(Entity entity);

    /**
     *
     * */
    void addBlock(Block block);

}
