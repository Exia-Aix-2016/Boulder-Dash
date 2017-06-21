package world.elements.entity;

import java.util.Stack;

/**
 * Manage the stat of Entity
 */
public class StateManager{
    private static final int SIZE_STACK = 5;
    private Stack<State> stateStack;

    private StateType requestState = null;

    public StateManager(){
        stateStack = new Stack<>();
        stateStack.setSize(SIZE_STACK);
    }
    public void pushState(StateType stateType){
        this.requestState = stateType;
        if (this.getCurrentState() == null){
            this.setRequestedState();
        }
    }

    private void setRequestedState(){
        stateStack.push(new State(requestState, false));
        System.out.println(this.getCurrentState());
        this.requestState = null;
    }

    private void refreshState(){
        if (requestState != null && requestState != this.getCurrentState().getStateType()){
            this.setRequestedState();
        }
    }


    /**
     * @return  the last State which push in Stack
     * */
    public State getCurrentState(){
        return stateStack.lastElement();
    }
    /**
     * @return  the State where index
     * */
    public State getState(final int index){
        return stateStack.get(index);
    }

    public void setBlockState(boolean blocked){
        if (!this.getCurrentState().isBlocked() == blocked){
            stateStack.push(new State(this.getCurrentState().getStateType(), blocked));
        }
    }


    public void tickStateManager(){
        this.refreshState();
        this.getCurrentState().incrementTick();
    }
}
