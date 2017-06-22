package world.elements.entity;

import world.elements.IAction;

import java.awt.*;

public interface IMovement extends IAction {
    void goRight();
    void goLeft();
    void goUp();
    void goDown();
    void goRest();
    StateManager getStateManager();
    boolean isEmpty(int xCase, int yCase);
}
