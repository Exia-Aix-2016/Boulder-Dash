package world.elements.entity;

import world.elements.IAction;

public interface IMovement extends IAction {
    void goRight();
    void goLeft();
    void goUp();
    void goDown();
    void goRest();
}
