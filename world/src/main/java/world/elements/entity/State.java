package world.elements.entity;

public class State {
    private StateType stateType;
    private int tick = 0;
    private boolean moving = false;
    private boolean blocked =true;

    private State lastSate;

    public void setStateType(StateType stateType) {
        if(this.moving == false)
            this.stateType = stateType;
    }

    public State getLastSate (){
        return lastSate;
    }

    public void setLastSate(Entity entity){
        this.lastSate = entity.state;
    }
}
