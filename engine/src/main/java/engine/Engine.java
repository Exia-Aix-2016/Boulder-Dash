package engine;

import world.IWorld;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

public class Engine extends JPanel{

    private IWorld world;

    private TickGenerator tickGenerator;
    private Thread tickGeneratorThread;

    private Image backgroundDirt;
    private Graphics g;

    public Engine(){
        this.setLayout(null);
        this.tickGenerator = new TickGenerator();


    }

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

    public Context getContext(Rectangle rectangle){
        return new Context(this.world.getComponents(), rectangle);
    }

    private void loadComponents(){
        Collection<JComponent> components = world.getComponents();

        for (JComponent component: components){
            component.setOpaque(false);
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
