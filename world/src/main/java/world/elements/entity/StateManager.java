package world.elements.entity;

import java.util.Stack;

/**
 * Manage the stat of Entity
 */
public class StateManager {
    private static final int SIZE_STACK = 5;
    private Stack<State> stateStack;

    public StateManager(){
        stateStack = new Stack<>();
        stateStack.setSize(SIZE_STACK);
    }
    public void pushState(StateType stateType){
        stateStack.push(new State(stateType));
    }

    /**
     * Increment the last State Tick
     * */
    public  void incrementStateTick(){
        this.getNowState().incrementTick();
    }

    /**
     * @return  the last State which push in Stack
     * */
    public State getNowState(){
        return stateStack.firstElement();
    }
    /**
     * @return  the State where index
     * */
    public State getState(final int index){
        return stateStack.get(index);
    }

}
