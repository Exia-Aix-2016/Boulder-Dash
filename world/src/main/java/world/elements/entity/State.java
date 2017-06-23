package world.elements.entity;


/**
 * its a entity State
 * @see StateType
 * */
public class State {
    private StateType stateType;
    private int tick = 0;
    private boolean moving;
    private boolean blocked;
    private int speed;

    State(StateType stateType, Boolean blocked, int speed){
        this.stateType = stateType;
        this.moving = false;
        this.blocked = blocked;
        this.speed = speed;
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

    public int getTicks() {
        return tick;
    }

    public int getSpeed() {
        return speed;
    }
}
