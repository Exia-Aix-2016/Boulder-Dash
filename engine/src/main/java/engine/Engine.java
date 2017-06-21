package engine;

import Hud.Hud;
import Hud.Info;
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

        Hud hud = new Hud(new GridLayout(1, 3));
        Info info = new Info("Score");


        this.setComponentZOrder(hud, 0);

        hud.setSize((int)this.getSize().getWidth(), 30);
        hud.setBackground(Color.YELLOW);
        hud.add(info);
        hud.add(new Info("Diamond remaining", 100));
        hud.add(new Info("Time", 1000));


       this.tickGeneratorThread = new Thread(tickGenerator);
       this.tickGeneratorThread.start();
    }
    /**
     * TODO
     * */
    public Context getContext(Rectangle rectangle){
        return new Context(this.world.getComponents(), rectangle);
    }

    @Override
    public void removeEntity(IComponent element) {
        this.remove((JComponent) element);
        this.revalidate();
        this.repaint();
        this.world.removeEntity(element);
    }

    @Override
    public void removeBlock(IComponent element) {
        this.remove((JComponent) element);
        this.revalidate();
        this.repaint();
        this.world.removeBlock(element);
    }

    @Override
    public void removeCharacter(IComponent element) {
        this.remove((JComponent) element);
        this.revalidate();
        this.repaint();
        this.world.removeCharacter(element);
    }

    /**
     * TODO
     * */
    private void loadComponents(){
        Collection<IComponent> components = world.getComponents();

        for (IComponent component: components){
            System.out.println(component);
            this.add((JComponent) component);
            component.setEngine(this);
        }
    }
    /**
     * TODO
     * */
    private void configureEntity(){
        Collection<IEntity> entities = world.getEntities();
        //Set Engine for all Entity
        for(IEntity entity : entities){
            this.tickGenerator.addTickListener(entity);
            entity.loadBehaviors();
        }
    }
}
