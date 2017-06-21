package world.behavior;

import world.elements.entity.IMovement;

public abstract class Behavior{

    protected IMovement elements;

    Behavior(IMovement elements){
        this.elements = elements;
    }

    public abstract void execute();
}
