package world.elements;
/**
 * TODO
 * */
public interface IAction {
    /**
     * TODO
     * */
    void destroy();
    /**
     * TODO
     * */
    void explode();
    /**
     * TODO
     * */
    boolean isReaction(Object from);
    /**
     * TODO
     * */
    void performReaction(Object from, int ticks);
}
