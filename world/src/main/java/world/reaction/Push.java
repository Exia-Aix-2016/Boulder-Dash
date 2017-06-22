package world.reaction;

import world.elements.entity.IMovement;

/**
 * Created by hougo on 22/06/2017.
 */
public class Push extends Reaction<IMovement, IMovement> {

    private int delay;

    /**
     * TODO
     *
     * @param iMovement
     * @param fromClass
     * @param sides
     */
    public Push(IMovement iMovement, Class<? extends IMovement> fromClass, Sides[] sides, int delay) {
        super(iMovement, fromClass, sides);
        this.delay = delay;
    }

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
