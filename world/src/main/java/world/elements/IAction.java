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
     * TODO
     * */
    void explode();
    /**
     * isReaction
     * check the if the object "form" came from the specific side "side"
     * @param Object
     * @param Sides
     * @return boolean
     * */
    boolean isReaction(Object from, Sides side);
    /**
     * performReaction
     * history of the object in terms of his sides
     * @param Object
     * @param Sides
     *@param int
     * @return boolean
     * */
    boolean performReaction(Object from, Sides side, int ticks);
}
