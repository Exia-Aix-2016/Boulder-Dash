package world.elements.entity;

import world.elements.IAction;

import java.util.Optional;


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
     * isEmpty
     * check if the specified coordinates are fulled
     * @return boolean
     * */
    boolean isEmpty(int xCase, int yCase);
    /**
     * Allow to ingnore the entity's behavior
     * */
    void ignoreBehavior();
    /**
     * hasFinished
     * check is the element had finished it current movement
     * @return boolean
     * */
    boolean hasFinish();

}
