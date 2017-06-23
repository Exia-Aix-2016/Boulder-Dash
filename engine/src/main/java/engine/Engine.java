package engine;

import Hud.Hud;
import Hud.Info;
import game.IFinishWorld;
import world.IComponent;
import world.IEntity;
import world.IWorld;
import Hud.Timer;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.Optional;


/**
 * TODO
 * @version 1.0
 * */
public class Engine extends JPanel implements IEngine{

    private IWorld world;

    private TickGenerator tickGenerator;
    private Thread tickGeneratorThread;
    private Hud hud;
    private IFinishWorld game;
    private Timer timer;

    public Engine(IFinishWorld game){
        this.setLayout(null);
        this.setFocusable(true);
        this.requestFocusInWindow();

        this.tickGenerator = new TickGenerator();

        this.game = game;
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

        hud = new Hud(new GridLayout(1, 3));

        this.setComponentZOrder(hud, 0);

        hud.setSize((int)this.getSize().getWidth(), 30);
        hud.setBackground(Color.YELLOW);

        this.timer = new Timer(this, this.hud, this.world.getTimeRemaining());
        this.tickGenerator.addTickListener(this.timer);

        hud.addInfo(new Info("Score"));
        hud.addInfo(new Info("Diamond remaining", this.world.getDiamonds_left()));

        this.playSound("Start");

       this.tickGeneratorThread = new Thread(tickGenerator);
       this.tickGeneratorThread.start();
    }

    private void unloadWorld(){
        this.world = null;
        this.hud = null;
        this.tickGeneratorThread.interrupt();
        this.tickGenerator.removeAllTickListeners();
        this.tickGeneratorThread = null;
        this.removeAll();
        this.revalidate();
        this.repaint();
    }

    public Optional<Info> getInfo(final String name){
        return this.hud.getInfo(name);
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

    @Override
    public void lose() {
        this.game.finished(false);
        this.playSound("Lose");
        this.unloadWorld();
    }

    @Override
    public void win() {
        this.game.finished(true);
        this.playSound("Win");
        this.unloadWorld();
    }
    // TODO
    @Override
    public boolean isOut(Rectangle projection) {
        return (
            0 > projection.x ||
            0 > projection.y ||
            this.getSize().width < projection.x + projection.width ||
            this.getSize().height < projection.y + projection.height
        );
    }

    @Override
    public boolean levelCompleted() {
        Optional<Info> d = this.getInfo("Diamond Remaining");
        if (d.isPresent()){
            return (d.get().get() <= 0);
        }
        return false;
    }

    @Override
    public void playSound(String filename) {
        new Sound(filename).start();
    }

    /**
     * TODO
     * */
    private void loadComponents(){
        Collection<IComponent> components = world.getComponents();

        for (IComponent component: components){
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
