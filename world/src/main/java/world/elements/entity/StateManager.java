package world.elements.entity;

import engine.Engine;
import engine.TickListener;

import java.util.Stack;

/**
 * Manage the stat of Entity
 */
public class StateManager implements TickListener{
    private static final int SIZE_STACK = 5;
    private Stack<State> stateStack;

    private StateType requestState;

    public StateManager(){
        stateStack = new Stack<>();
        stateStack.setSize(SIZE_STACK);
    }
    public void pushState(StateType stateType){
        stateStack.push(new State(stateType, false));
    }


    /**
     * @return  the last State which push in Stack
     * */
    public State getCurrentState(){
        return stateStack.firstElement();
    }
    /**
     * @return  the State where index
     * */
    public State getState(final int index){
        return stateStack.get(index);
    }

    public void setBlockState(){
        stateStack.push(new State(this.getCurrentState().getStateType(), true));

    }

    @Override
    public void tick() {
        this.getCurrentState().incrementTick();
    }
}
