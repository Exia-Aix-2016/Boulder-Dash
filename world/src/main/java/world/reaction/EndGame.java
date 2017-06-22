package world.reaction;

import world.elements.IAction;
import world.elements.entity.IMovement;

/**
 * Created by hougo on 22/06/2017.
 */
public class EndGame extends Reaction<IMovement, IAction> {


    /**
     * TODO
     *
     * @param iAction
     * @param fromClass
     * @param sides
     */
    public EndGame(IAction iAction, Class<? extends IMovement> fromClass, Sides[] sides) {
        super(iAction, fromClass, sides);
    }

    @Override
    protected boolean execute(int ticks) {
        if (this.from.hasFinish()){
            this.to.destroy();
            return true;
        }
        return false;
    }
}
