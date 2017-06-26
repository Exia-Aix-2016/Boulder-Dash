package world.behavior;


import world.elements.IAction;
import world.elements.entity.Character;
import world.elements.entity.Entity;
import world.elements.entity.IMovement;
import world.elements.entity.StateType;




public class IAHostile extends Behavior {

    private static Entity entity;

    public IAHostile(IMovement element){
        super(element);
        entity = (Entity) this.element;


    }

    @Override
    public void execute() {
        for(int i = 1; i < 5; i++){
            entity.getContext(entity.getProjection(i, 0)).ifPresent(IAHostile::executeOpHunter);
            entity.getContext(entity.getProjection(-i, 0)).ifPresent(IAHostile::executeOpHunter);
            entity.getContext(entity.getProjection(0, i)).ifPresent(IAHostile::executeOpHunter);
            entity.getContext(entity.getProjection(0, -i)).ifPresent(IAHostile::executeOpHunter);
        }



    }

    private  static void executeOpHunter(IAction target){

        if(target instanceof Character){

            if(entity.getPosition().getX() < ((Character) target).getPosition().getX()){
                entity.getStateManager().pushState(StateType.RIGHT);
            }
            if(entity.getPosition().getX() > ((Character) target).getPosition().getX()){
                entity.getStateManager().pushState(StateType.LEFT);
            }
            if(entity.getPosition().getY() > ((Character) target).getPosition().getY()){
                entity.getStateManager().pushState(StateType.UP);
            }
            if(entity.getPosition().getY() < ((Character) target).getPosition().getY()){
                entity.getStateManager().pushState(StateType.DOWN);
            }




        }

    }
}
