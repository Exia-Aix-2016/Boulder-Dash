package world.behavior;

import world.elements.entity.IMovement;

public abstract class Behavior{

    protected IMovement element;

    Behavior(IMovement element){
        this.element = element;
    }

    public abstract void execute();
}
