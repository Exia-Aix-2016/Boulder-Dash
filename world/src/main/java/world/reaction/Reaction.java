package world.reaction;

import world.elements.IAction;

public abstract class Reaction <From extends IAction, To extends IAction> {

    protected To to;
    private Class<? extends From> fromClass;

    Reaction(To to, Class<? extends From> fromClass){
        this.to = to;
        this.fromClass = fromClass;
    }

    public boolean isReaction(Class<? extends IAction> from){
        return fromClass.isInstance(from);
    }

    public void perform(Class<? extends IAction> from, int ticks){
        if (isReaction(from)){
            this.execute();
        }
    }

    protected abstract void execute();
}