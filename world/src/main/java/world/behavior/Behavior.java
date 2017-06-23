package world.behavior;

import world.elements.entity.IMovement;

/**
 * Abstract class Behavior
 * Describes the behavior of an element, mainly of it movement
 * @see IMovement
 * */
public abstract class Behavior{

    protected IMovement element;

    /**
     * Behavior
     * change the movement of  an element
     * @see IMovement
     * */
    Behavior(IMovement element){
        this.element = element;
    }

    public abstract void execute();
}
