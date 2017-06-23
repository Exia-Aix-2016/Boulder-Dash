package world.reaction;

import world.elements.IAction;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The type Reaction define the mechanics when an element hit an other.
 *
 * @param <From> the type the element that hit;
 * @param <To>   the type the element that be hit;
 */
public abstract class Reaction <From extends IAction, To extends IAction> {

    protected To to;
    protected From from;
    private Class<? extends From> fromClass;
    protected Collection<Sides> sides = new ArrayList<>();

    /**
     * Instantiates a new Reaction.
     *
     * @param to        the to
     * @param fromClass the from class
     * @param sides     the sides that can be hit
     */
    Reaction(To to, Class<? extends From> fromClass, Sides[] sides){
        this.to = to;
        this.fromClass = fromClass;
        for (Sides side: sides){
            this.sides.add(side);
        }
    }

    /**
     * Is reaction test if and element will react.
     *
     * @param from the from
     * @param side the side
     * @return the boolean
     */
    public boolean isReaction(Object from, Sides side){
        return (fromClass.isInstance(from) && this.sides.contains(side));
    }

    /**
     * Perform execute the reaction.
     *
     * @param from  the from
     * @param side  the side
     * @param ticks the ticks
     * @return the boolean
     */
    public boolean perform(Object from, Sides side, int ticks){
        if (isReaction(from, side)){
            this.from = (From) from;
            return this.execute(ticks);
        }
        return false;
    }

    /**
     * Execute is the reaction mechanism.
     *
     * @param ticks the ticks
     * @return the boolean
     */
    protected abstract boolean execute(int ticks);
}