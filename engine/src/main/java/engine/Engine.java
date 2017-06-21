package engine;

import world.IComponent;
import world.IEntity;
import world.IWorld;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class Engine extends JPanel{

    IWorld world;

    TickGenerator tickGenerator;
    Thread tickGeneratorThread;

    public Engine(){
        this.setLayout(null);
        this.tickGenerator = new TickGenerator();
    }

    public void loadWorld(IWorld world){
        this.world = world;

        this.loadComponents();
        this.configureEntity();

        this.revalidate();
        this.repaint();

       this.tickGeneratorThread = new Thread(tickGenerator);

       this.tickGeneratorThread.start();
    }

    public Context getContext(Rectangle rectangle){
        return new Context(this.world.getComponents(), rectangle);
    }

    private void loadComponents(){
        Collection<IComponent> components = world.getComponents();

        for (IComponent component: components){
            System.out.println(component);
            this.add((JComponent) component);
        }
    }

    private void configureEntity(){
        Collection<IEntity> entities = world.getEntities();
        //Set Engine for all Entity
        for(IEntity entity : entities){
            entity.setEngine(this);
            this.tickGenerator.addTickListener(entity);
        }
    }
}
