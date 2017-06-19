package world;

import world.elements.block.Block;
import world.elements.entity.Entity;

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
