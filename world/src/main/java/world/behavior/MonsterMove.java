package world.behavior;

import world.elements.entity.IMovement;
import world.elements.entity.StateType;

/**
 * The Behavior Monvement for the Monster
 */
public class MonsterMove extends Behavior {

    public MonsterMove(IMovement element){
        super(element);


    }

    @Override
    public void execute() {
        if(element.getStateManager().getCurrentState() != null){
            if(element.getStateManager().getCurrentState().getStateType() != StateType.RIGHT)
                element.getStateManager().pushState(StateType.LEFT);
        }
        if(element.getStateManager().getCurrentState().isBlocked()){
            switch (element.getStateManager().getCurrentState().getStateType()){
                case RIGHT:
                    element.goLeft();
                    break;
                case LEFT:
                    element.goRight();
                    break;
            }
        }


    }
}
