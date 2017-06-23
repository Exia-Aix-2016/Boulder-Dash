package world.reaction;

import world.elements.IAction;
import world.elements.entity.IMovement;

/**
 * The type InertiaRemove.
 */
public class InertiaRemove extends Remove {

    /**
     * Instantiates a new Inertia remove.
     *
     * @param to        the to
     * @param typeClass the from class
     * @param sides     the sides
     */
    public InertiaRemove(IAction to, Class<? extends IMovement> typeClass, Sides[] sides) {
        super(to, typeClass, sides);
    }

    /**
     * Remove the to element when the from element has inertia.
     *
     * @param ticks the ticks
     * @return the boolean
     */
    @Override
    protected boolean execute(int ticks) {
        if (this.from.getStateManager().getCurrentState().getTicks() < 10){
            return super.execute(ticks);
        }
        return false;
    }
}
