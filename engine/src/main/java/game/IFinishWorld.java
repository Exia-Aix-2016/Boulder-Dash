package game;

/**
 * Represente the methods which call when the game is finish.
 */
public interface IFinishWorld {
    /**
     * Call when the game is finish
     * @param win define if finish in win or not
     * */
    void finished(boolean win);
}
