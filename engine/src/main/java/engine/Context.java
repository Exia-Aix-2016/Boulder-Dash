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
public class Context implements Runnable  {

    private Rectangle rectangle;
    private Collection<JComponent> worldComponents;
    private JComponent foundCompenent = null;


    /**
     * Contructor Context
     * @param worldComponents Collection(JComponent)
     * @param rectangle the cursor element to search in worldComponents
     * */
    public Context(Collection<JComponent> worldComponents, Rectangle rectangle){
        this.rectangle = rectangle;
        this.worldComponents = worldComponents;
    }

    /**
     * Allow to calculate the context (check collision)
     * */
    @Override
    public void run() {
        for(JComponent component : worldComponents){
            if(rectangle.intersects(component.getBounds())){
                foundCompenent = component;
            }
        }

        this.notify();
    }

    /**
     * Allow to get the context this method start the thread context
     * @return Optional(JComponent) if the context found the block return JComponent else Optional.empty()
     * @see JComponent
     * @see Optional
     * @see Runnable
     * */
    public Optional<JComponent> getContext(){
        Thread startCalcContext = new Thread(this);
        startCalcContext.start();

        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(foundCompenent != null){
            return Optional.of(foundCompenent);
        }else {
            return Optional.empty();
        }
    }
}
