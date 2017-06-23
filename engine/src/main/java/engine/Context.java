package engine;

import world.IComponent;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.Optional;

/**
 *Allow to check if the action of a entity is possible, this Thread return the block found
 * @see Runnable
 * @see JComponent
 */
public class Context {

    /**
     * Represente the virtual rectangle which placed forward the entities which need the context
     * @see Rectangle
     * */
    private Rectangle rectangle;
    /**
     * Its a list of all Components in game's map
     * @see IComponent
     * */
    private Collection<IComponent> worldComponents;

    /**
     * Allow to get the context when a entity request
     * @return The context which requested by an entity
     * @param rectangle Represente a virtual rectangle forward entities
     * @see Context
     * */
    Context(Collection<IComponent> worldComponents, Rectangle rectangle){
        this.rectangle = rectangle;
        this.worldComponents = worldComponents;
    }

    /**
     * Allow to get the context this method start the thread context
     * @return Optional(JComponent) if the context found the block return JComponent else Optional.empty()
     * @see JComponent
     * @see Optional
     * */
    public Optional<IComponent> get(){

        for(IComponent component : worldComponents){
            if(rectangle.intersects(component.getBounds())){
                return  Optional.of(component);
            }
        }
        return Optional.empty();
    }
}
