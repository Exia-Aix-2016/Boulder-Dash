package world.reaction;

import world.elements.entity.IMovement;
import world.elements.entity.StateType;

/**
 * The type Heap.
 */
public class Heap extends Reaction<IMovement, IMovement>{

    /**
     * Instantiates a new Heap.
     *
     * @param iMovement the to
     * @param fromClass the from class
     */
    public Heap(IMovement iMovement, Class<? extends IMovement> fromClass) {
        super(iMovement, fromClass, new Sides[]{Sides.TOP});
    }

    /**
     * Try to create a heap.
     *
     * @param ticks the ticks
     * @return the boolean
     */
    @Override
    protected boolean execute(int ticks) {

        boolean left2 = this.from.isEmpty(-1, 0);
        boolean left1 = this.to.isEmpty(-1, 0);

        boolean right2 = this.from.isEmpty(1, 0);
        boolean right1 = this.to.isEmpty(1, 0);

        if (left1 && left2){
            this.from.getStateManager().pushState(StateType.LEFT);
            return true;
        } else if (right1 && right2){
            this.from.getStateManager().pushState(StateType.RIGHT);
            return true;
        }

        return false;
    }
}
