package world.reaction;

import world.elements.IAction;
import world.elements.entity.IMovement;

public class Remove extends Reaction<IMovement, IAction> {

    private int delay;

    public Remove(IAction to, Class<? extends IMovement> typeClass, int delay){
        super(to, typeClass);
        this.delay = delay;
    }

    @Override
    protected void execute() {

    }
}