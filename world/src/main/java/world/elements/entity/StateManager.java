package world.elements.entity;

import java.util.Stack;

/**
 * Manage the stat of Entity
 */
public class StateManager{
    private static final int SIZE_STACK = 5;
    private Stack<State> stateStack;

    private StateType requestState = null;

    private int default_speed;

    public StateManager(int default_speed){
        stateStack = new Stack<>();
        stateStack.setSize(SIZE_STACK);
        this.default_speed = default_speed;
    }

    public void pushState(StateType stateType){
        this.requestState = stateType;
        if (this.getCurrentState() == null){
            this.setRequestedState(default_speed);
        }
    }

    private void setRequestedState(int speed){
        stateStack.push(new State(requestState, false, speed));
        this.requestState = null;
    }

    private void refreshState(){
        if (requestState != null && requestState != this.getCurrentState().getStateType()){
            this.setRequestedState(this.getCurrentState().getSpeed());
        }
    }


    /**
     * @return  the last State which push in Stack
     * */
    public State getCurrentState(){
        return stateStack.lastElement();
    }
    /**
     * @param index index
     * @return  the State where index
     * */
    public State getState(final int index){
        return stateStack.get(index);
    }

    public void setBlockState(boolean blocked){
        if (!this.getCurrentState().isBlocked() == blocked && !this.getCurrentState().isMoving()){
            stateStack.push(new State(this.getCurrentState().getStateType(), blocked, this.getCurrentState().getSpeed()));
        }
    }

    public void setSpeed(int speed){
        if (!this.getCurrentState().isMoving() && this.getCurrentState().getSpeed() != speed){
            stateStack.push(new State(this.getCurrentState().getStateType(), false, speed));
        }
    }

    public void setDefaultSpeed(){
        this.setSpeed(this.default_speed);
    }


    public void tickStateManager(){
        this.refreshState();
        this.getCurrentState().incrementTick();
    }

    public void clone(State state){
        this.stateStack.push(state);
    }
}
