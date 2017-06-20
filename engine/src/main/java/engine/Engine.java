package engine;

import world.IWorld;

import javax.swing.*;
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
        this.addEntityTick();

        this.revalidate();
        this.repaint();

       this.tickGeneratorThread = new Thread(tickGenerator);

       this.tickGeneratorThread.start();
    }

    private void loadComponents(){
        Collection<JComponent> components = world.getComponents();

        for (JComponent component: components){
            System.out.println(component);
            this.add(component);
        }
    }

    private void addEntityTick(){
        Collection<TickListener> tickListeners = world.getTickListeners();
        this.tickGenerator.addAllTickListeners(tickListeners);
    }
}
