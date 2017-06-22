package world.reaction;

import world.elements.IAction;

/**
 * Abstract class Reaction
 *
 * TODO
 *
 * @see IAction
 * */

public abstract class Reaction <From extends IAction, To extends IAction> {

    protected To to;
    protected From from;
    private Class<? extends From> fromClass;

    /**
     * TODO
     * */
    Reaction(To to, Class<? extends From> fromClass){
        this.to = to;
        this.fromClass = fromClass;
    }
    /**
     * TODO
     * */
    public boolean isReaction(Object from){
        return fromClass.isInstance(from);
    }
    /**
     * TODO
     * */
    public boolean perform(Object from, int ticks){
        if (isReaction(from)){
            this.from = (From) from;
            return this.execute(ticks);
        }
        return false;
    }
    /**
     * TODO
     * */
    protected abstract boolean execute(int ticks);
}