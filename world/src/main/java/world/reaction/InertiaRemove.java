package world.reaction;

import world.elements.IAction;
import world.elements.entity.IMovement;

/**
 * Created by hougo on 22/06/2017.
 */
public class InertiaRemove extends Remove {
    public InertiaRemove(IAction to, Class<? extends IMovement> typeClass, Sides[] sides) {
        super(to, typeClass, sides);
    }

    @Override
    protected boolean execute(int ticks) {
        System.out.println(this.from.getStateManager().getCurrentState().getTicks());
        if (this.from.getStateManager().getCurrentState().getTicks() < 10){
            return super.execute(ticks);
        }
        return false;
    }
}
