package world.elements.entity;

import world.elements.IAction;

import java.awt.*;


public interface IMovement extends IAction {
    /**
     * To go entity right
     * */
    void goRight();
    /**
     * To go entity left
     * */
    void goLeft();
    /**
     * To go entity up
     * */
    void goUp();
    /**
     * To go entity down
     * */
    void goDown();
    /**
     * To go entity waiting
     * */
    void goRest();
    /**
     * @return the stateManager
     * @see StateManager
     * @see StateType
     * @see State
     * */
    StateManager getStateManager();
    /**
     * TODO
     * */
    boolean isEmpty(int xCase, int yCase);
    /**
     * Allow to ingnore the entity's behavior
     * */
    void ignoreBehavior();
    /**
     * TODO
     * */
    boolean hasFinish();
}
