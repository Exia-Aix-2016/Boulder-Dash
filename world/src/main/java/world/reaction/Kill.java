package world.reaction;

import world.elements.entity.IMovement;

/**
 * class Kill
 *
 * @see IMovement
 */
public class Kill extends Reaction<IMovement, IMovement> {
    /**
     * Kill
     *
     * @param iMovement
     * @param fromClass
     * @param sides
     */
    public Kill(IMovement iMovement, Class<? extends IMovement> fromClass, Sides[] sides) {
        super(iMovement, fromClass, sides);
    }

    @Override
    protected boolean execute(int ticks) {
        this.from.destroy();
        return true;
    }
}
