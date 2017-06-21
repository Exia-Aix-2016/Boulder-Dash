package world;

import world.elements.block.Block;
import world.elements.entity.Entity;

/**
 * Interface ICreateWorld
 * Interface to allows the elements to a new world
 */
public interface ICreateWorld {

    /**
     *Add an entity in the entities' arrayList of the new world
     * @see Entity
     * */
    void addEntity(Entity entity);

    /**
     *Add a block in the blocks' arrayList of the world
     * @see Block
     * */
    void addBlock(Block block);

}
