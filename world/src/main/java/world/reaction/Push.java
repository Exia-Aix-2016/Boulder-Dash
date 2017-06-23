package world.reaction;

import world.elements.entity.IMovement;

/**
 * The type Push.
 */
public class Push extends Reaction<IMovement, IMovement> {

    private int delay;

    /**
     * Instantiates a new Push.
     *
     * @param iMovement the to
     * @param fromClass the from class
     * @param sides     the sides
     * @param delay     the delay
     */
    public Push(IMovement iMovement, Class<? extends IMovement> fromClass, Sides[] sides, int delay) {
        super(iMovement, fromClass, sides);
        this.delay = delay;
    }

    /**
     * Push the to element when a delay is reached.
     *
     * @param ticks the ticks
     * @return the boolean
     */
    @Override
    protected boolean execute(int ticks) {
        if (ticks > delay){

            boolean canBeMoved = false;

            switch (this.from.getStateManager().getCurrentState().getStateType()){

                case RIGHT:
                    canBeMoved = this.to.isEmpty(1,0);
                    break;
                case LEFT:
                    canBeMoved = this.to.isEmpty(-1, 0);
                    break;

            }

            if (canBeMoved){
                this.to.getStateManager().pushState(this.from.getStateManager().getCurrentState().getStateType());
                this.to.getStateManager().setSpeed(5);

                this.from.getStateManager().clone(this.to.getStateManager().getCurrentState());

                this.to.ignoreBehavior();
                this.from.ignoreBehavior();
            }

        }
        return false;
    }
}
