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
    public Remove(IAction to, Class<? extends IMovement> typeClass, Sides[] sides, int delay){
        super(to, typeClass, sides);
        this.delay = delay;
    }

    @Override
    protected boolean execute(int ticks) {
        if (ticks > this.delay){
            this.to.destroy();
            this.from.getStateManager().setSpeed(2);
            return true;
        }
        return false;
    }
}