package world.behavior;

public abstract class Behavior implements IBehaviorControl{

    protected IBehavior elements;

    public Behavior(IBehavior elements){
        this.elements = elements;
    }
}
