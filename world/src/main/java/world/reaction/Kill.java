package world.reaction;

import world.elements.entity.IMovement;

/**
 * TODO
 */
public class Kill extends Reaction<IMovement, IMovement> {
    /**
     * TODO
     *
     * @param iMovement TODO
     * @param fromClass TODO
     * @param sides TODO
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
