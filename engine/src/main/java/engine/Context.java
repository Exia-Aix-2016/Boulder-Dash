package engine;

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

    private Rectangle rectangle;
    private Collection<JComponent> worldComponents;


    /**
     * Contructor Context
     * @param worldComponents Collection(JComponent)
     * @param rectangle the cursor element to search in worldComponents
     * */
    Context(Collection<JComponent> worldComponents, Rectangle rectangle){
        this.rectangle = rectangle;
        this.worldComponents = worldComponents;
    }

    /**
     * Allow to get the context this method start the thread context
     * @return Optional(JComponent) if the context found the block return JComponent else Optional.empty()
     * @see JComponent
     * @see Optional
     * @see Runnable
     * */
    public Optional<JComponent> get(){

        for(JComponent component : worldComponents){
            if(rectangle.intersects(component.getBounds())){
                return  Optional.of(component);
            }
        }

        return Optional.empty();
    }
}
