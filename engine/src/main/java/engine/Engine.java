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
 * The Engine allow to manage the world, entities, sound, display, HUD, etc...
 * @version 1.0
 * */
public class Engine extends JPanel implements IEngine{

    /**
     * The game's world
     * */
    private IWorld world;

    /**
     * TickGenerator
     * */
    private TickGenerator tickGenerator;
    /**
     * tread of the tickGenerator
     * */
    private Thread tickGeneratorThread;
    /**
     * The HUD which display the informations
     * */
    private Hud hud;

    /**
     * The interface when the game is finish
     * */
    private IFinishWorld game;
    private Timer timer;

    /**
     * Engine contructor
     * @param game Interface when game is finish
     * */
    public Engine(IFinishWorld game){
        this.setLayout(null);
        this.setFocusable(true);
        this.requestFocusInWindow();

        this.tickGenerator = new TickGenerator();

        this.game = game;

        new Sound("ambiance", true).start();
    }

    /**
     * This method allow to load a world, create Hud and it information
     * and start the tick generator
     * @param world the world you want load
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

    /**
     * Allow to unload the world
     * */
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

    /**
     * Allow to get the information to the change them
     *@return Optional(info) if the information it is present return Optional(Info) else Optional.empty()
     * @see Info
     * @see Optional
     * */
    public Optional<Info> getInfo(final String name){
        return this.hud.getInfo(name);
    }

    @Override
    public Context getContext(Rectangle rectangle){
        return new Context(this.world.getComponents(), rectangle);
    }

    @Override
    public void removeEntity(IComponent element) {
        this.remove((JComponent) element);
        this.revalidate();
        this.repaint();
        this.tickGenerator.removeTickListener((TickListener) element);
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
     * Allow to loadComponents in engine
     * the entities recover the engine reference
     * */
    private void loadComponents(){
        Collection<IComponent> components = world.getComponents();

        for (IComponent component: components){
            this.add((JComponent) component);
            component.setEngine(this);
        }
    }
    /**
     * Allow to configure entities
     * - add in tickGenerator the entities(TickListerners)
     * - load the entitie's behaviors
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
