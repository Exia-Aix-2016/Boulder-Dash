package world.reaction;

import world.elements.entity.IMovement;

/**
 * Created by hougo on 23/06/2017.
 */
public class Kill extends Reaction<IMovement, IMovement> {
    /**
     * TODO
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
