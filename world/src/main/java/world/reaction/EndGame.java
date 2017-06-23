package world.reaction;

import world.elements.IAction;
import world.elements.entity.IMovement;

/**
 * The type End game.
 */
public class EndGame extends Reaction<IMovement, IAction> {

    /**
     * Instantiates a new End game.
     *
     * @param iAction   the to
     * @param fromClass the from class
     * @param sides     the sides
     */
    public EndGame(IAction iAction, Class<? extends IMovement> fromClass, Sides[] sides) {
        super(iAction, fromClass, sides);
    }

    /**
     * Remove the to element if the game is finished.
     *
     * @param ticks the ticks
     * @return the boolean
     */
    @Override
    protected boolean execute(int ticks) {
        if (this.from.hasFinish()){
            this.to.destroy();
            return true;
        }
        return false;
    }
}
