package world.reaction;

import world.elements.IAction;
import world.elements.entity.IMovement;
/**
 * TODO
 * */
public class Remove extends Reaction<IMovement, IAction> {

    private int delay;
    /**
     * TODO
     * */
    public Remove(IAction to, Class<? extends IMovement> typeClass, int delay){
        super(to, typeClass);
        this.delay = delay;
    }

    @Override
    protected void execute() {

    }
}