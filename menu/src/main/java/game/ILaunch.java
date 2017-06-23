package game;

import engine.Engine;
import world.World;
/**
 * TODO
 * */
public interface ILaunch {
    /**
     * launch
     * recover the information of the gameboot's map to create a new "world", a level of the game. Then, set the engine for it, remove the menu and instantiate the key manager
     * @see Engine
     * @see World
     * @param worldName name of the world you can load
     * */
    void launch(String worldName);
}
