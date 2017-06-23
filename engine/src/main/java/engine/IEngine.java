package engine;

import Hud.Info;
import world.IComponent;

import java.awt.*;
import java.awt.event.KeyListener;
import java.util.Optional;

/**
 * Interface for engine
 * @version 1.0
 * */
public interface IEngine {
    /**
     * Allow to add KeyListerner
     * @param keyListener add the KeyListener
     * @see KeyListener
     * */
    void addKeyListener(KeyListener keyListener);
    /**
     * Allow to get Context for the entities.
     * a context is a element forward the entity.
     * @return the context entity
     *@param rectangle Represente a virtual Rectangle forward the entities
     * @see Context
     * */
    Context getContext(Rectangle rectangle);

    /**
     * Allow to remove Entity
     * @param element you want remove
     * */
    void removeEntity(IComponent element);

    /**
     * Allow to remove block
     * @param element you want add
     * */
    void removeBlock(IComponent element);

    /**
     * Allow to remove character
     * @param element Element you want remove
     * */
    void removeCharacter(IComponent element);

    /**
     * @return  information displayed by HUD
     * @param name Name of Info Displayed
     * @see Hud
     * @see Info
     * */
    Optional<Info> getInfo(final String name);

    /**
     * This method is call when player lose the game
     * (Kill by monster or died)
     * */
    void lose();

    /**
     * When the player has get all diamond on the map and cross the exit
     * this method is call
     * */
    void win();

    /**
     * @return true if the rectangle is out of false if it is not.
     * @param projection the rectangle you want test.
     * */
    boolean isOut(Rectangle projection);

    /**
     * @return true if the level is complete or false if it is not.
     * */
    boolean levelCompleted();

    /**
     * Allow to play a sound
     * @param filename Name of the file sound, you want play.
     * */
    void playSound(String filename);
}
