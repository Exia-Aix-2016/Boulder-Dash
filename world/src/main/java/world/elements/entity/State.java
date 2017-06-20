package world.elements.entity;

public class State {
    private StateType stateType;
    private int tick = 0;
    private boolean moving;
    private boolean blocked;

    State(StateType stateType, Boolean blocked){
        this.stateType = stateType;
        this.moving = false;
        this.blocked = blocked;
    }
    /**
     * @return the state type
     * */
    public StateType getStateType() {
        return stateType;
    }


    /**
     * increment the tick of the current state use by the entities
     * */
    public void incrementTick(){
        this.tick++;
    }

    /**
     * set moving the state
     * */
    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    /**
     * @return if blocked is true or false
     * */
    public boolean isBlocked() {
        return blocked;
    }
    /**
     * @return if moving is true or false
     * */
    public boolean isMoving() {
        return moving;
    }
}
