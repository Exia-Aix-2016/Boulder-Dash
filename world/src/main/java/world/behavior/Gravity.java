package world.behavior;

import world.elements.entity.IMovement;
import world.elements.entity.StateType;

public class Gravity extends Behavior{

    /**
     * Gravity
     * change the movement of  an element to left
     *
     * @param element
     * @see IMovement
     */
    public Gravity(IMovement element) {
        super(element);
    }

    @Override
    public void execute() {
        this.element.getStateManager().pushState(StateType.DOWN);
    }
}
