package world.reaction;

import world.elements.IAction;
import world.elements.entity.IMovement;

/**
 * class Remove
 *
 * TODO
 *
 * @see Reaction
 * @see IMovement
 * @see IAction
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
        this.to.destroy();
    }
}