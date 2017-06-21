package engine;

import world.IWorld;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.Optional;

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
        Collection<JComponent> components = world.getComponents();

        for (JComponent component: components){
            System.out.println(component);
            this.add(component);
        }
    }

    private void configureEntity(){
        Collection<TickListener> tickListeners = world.getTickListeners();
        //Set Engine for all Entity
        for(TickListener tickListener : tickListeners){
            ((IEngine)tickListener).setEngine(this);
        }
        this.tickGenerator.addAllTickListeners(tickListeners);
    }
}
