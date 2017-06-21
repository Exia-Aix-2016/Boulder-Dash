package world.behavior;

import world.elements.entity.IMovement;

/**
 * Abstract class Behavior
 * Describes the behavior of an element, mainly of it movement
 * @see IMovement
 * */
public abstract class Behavior{

    protected IMovement elements;

    /**
     * Behavior
     * change the movement of  an element
     * @see IMovement
     * */
    Behavior(IMovement elements){
        this.elements = elements;
    }

    public abstract void execute();
}
