package world.elements;

import world.reaction.Sides;

/**
 * interface IAction
 * refer every types of actions an object will meet
 * @see Elements
 * @see world.reaction.EndGame
 * @see world.reaction.Reaction
 * @see world.reaction.Remove
 * */
public interface IAction {
    /**
     * destroy
     * used to remove an element an element from the map
     * */
    void destroy();
    /**
     * When the entity explode
     * */
    void explode();
    /**
     * isReaction
     * check the if the object "form" came from the specific side "side"
     * @param from from element
     * @param side side
     * @return boolean
     * */
    boolean isReaction(Object from, Sides side);
    /**
     * performReaction
     * history of the object in terms of his sides
     * @param from from element
     * @param side side
     * @param ticks ticks
     * @return true if the reaction perfom else false
     * */
    boolean performReaction(Object from, Sides side, int ticks);
}
