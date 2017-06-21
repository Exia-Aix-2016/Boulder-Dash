package world.behavior;

public abstract class Behavior {

    protected IBehavior elements;

    public Behavior(IBehavior elements){
        this.elements = elements;
    }
}
