package world.reaction;

import world.elements.entity.IMovement;

/**
 * The type Kill.
 */
public class Kill extends Reaction<IMovement, IMovement> {

    /**
     * Instantiates a new Kill.
     *
     * @param iMovement the to
     * @param fromClass the from class
     * @param sides     the sides
     */
    public Kill(IMovement iMovement, Class<? extends IMovement> fromClass, Sides[] sides) {
        super(iMovement, fromClass, sides);
    }

    /**
     * Kill the from element when a it hit the to element.
     *
     * @param ticks the ticks
     * @return the boolean
     */
    @Override
    protected boolean execute(int ticks) {
        this.from.destroy();
        return true;
    }
}
