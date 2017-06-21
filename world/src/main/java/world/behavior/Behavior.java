package world.behavior;

import world.elements.entity.IMovement;
/**
 * TODO
 * */
public abstract class Behavior{

    protected IMovement element;
    /**
     * TODO
     * */
    Behavior(IMovement element){
        this.element = element;
    }

    public abstract void execute();
}
