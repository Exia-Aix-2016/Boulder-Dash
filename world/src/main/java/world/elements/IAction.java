package world.elements;

public interface IAction {
    void destroy();
    void explode();
    boolean isReaction(Class<? extends IAction> from);
    void performReaction(Class<? extends IAction> from, int ticks);
}
