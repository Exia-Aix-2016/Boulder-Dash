package world.elements;

import world.reaction.Sides;

/**
 * TODO
 * */
public interface IAction {
    /**
     * TODO
     * */
    void destroy();
    /**
     * TODO
     * */
    void explode();
    /**
     * TODO
     * */
    boolean isReaction(Object from, Sides side);
    /**
     * TODO
     * */
    boolean performReaction(Object from, Sides side, int ticks);
}
