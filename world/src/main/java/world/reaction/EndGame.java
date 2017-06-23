package world.reaction;

import world.elements.IAction;
import world.elements.entity.IMovement;

public class EndGame extends Reaction<IMovement, IAction> {


    /**
     * EndGame
     *construction of the class.
     * @param iAction TODO
     * @param fromClass TODO
     * @param sides TODO
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
