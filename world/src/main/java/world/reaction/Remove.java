package world.reaction;

import world.elements.IAction;
import world.elements.entity.IMovement;

/**
 * The type Remove is a reaction which define that an element can be removed by an other.
 *
 * @see Reaction
 * @see IMovement
 * @see IAction
 * */
public class Remove extends Reaction<IMovement, IAction> {

    private int delay;

    /**
     * Instantiates a new Remove.
     *
     * @param to        the to
     * @param typeClass the from class
     * @param sides     the sides
     * @param delay     the delay
     */
    public Remove(IAction to, Class<? extends IMovement> typeClass, Sides[] sides, int delay){
        super(to, typeClass, sides);
        this.delay = delay;
    }

    /**
     * Instantiates a new Remove.
     *
     * @param to        the to
     * @param typeClass the type class
     * @param sides     the sides
     */
    public Remove(IAction to, Class<? extends IMovement> typeClass, Sides[] sides){
        super(to, typeClass, sides);
        this.delay = 0;
    }

    /**
     * Remove the to element when a delay is reached and slow the from element.
     *
     * @param ticks the ticks
     * @return the boolean
     */
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