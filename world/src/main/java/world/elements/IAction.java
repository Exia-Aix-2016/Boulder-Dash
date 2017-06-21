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
    boolean isReaction(Class<? extends IAction> from);
    /**
     * TODO
     * */
    void performReaction(Class<? extends IAction> from, int ticks);
}
