package engine;

import world.IComponent;
import world.IEntity;
import world.IWorld;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

/**
 * TODO
 * @version 1.0
 * */
public class Engine extends JPanel implements IEngine{

    private IWorld world;

    private TickGenerator tickGenerator;
    private Thread tickGeneratorThread;

    private Image backgroundDirt;
    private Graphics g;

    public Engine(){
        this.setLayout(null);
        this.setFocusable(true);
        this.requestFocusInWindow();

        this.tickGenerator = new TickGenerator();

    }

    /**
     * TODO
     * */
    public void loadWorld(IWorld world){
        this.world = world;

        this.setBackground(Color.black);
        this.loadComponents();
        this.configureEntity();
        this.revalidate();

        this.repaint();

       this.tickGeneratorThread = new Thread(tickGenerator);

       this.tickGeneratorThread.start();
    }
    /**
     * TODO
     * */
    public Context getContext(Rectangle rectangle){
        return new Context(this.world.getComponents(), rectangle);
    }
    /**
     * TODO
     * */
    private void loadComponents(){
        Collection<IComponent> components = world.getComponents();

        for (IComponent component: components){
            System.out.println(component);
            this.add((JComponent) component);
        }
    }
    /**
     * TODO
     * */
    private void configureEntity(){
        Collection<IEntity> entities = world.getEntities();
        //Set Engine for all Entity
        for(IEntity entity : entities){
            entity.setEngine(this);
            this.tickGenerator.addTickListener(entity);
            entity.loadBehaviors();
        }
    }
}
