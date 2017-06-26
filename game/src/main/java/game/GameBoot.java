package game;

import dao.IMap;
import dao.MapDAO;
import engine.Engine;
import world.World;
import worldloader.WorldLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * class GameBoot
 * the window of the program, composed of many panels
 * @see JFrame
 * @see JPanel
 * @see ILaunch
 * @see IFinishWorld
 * */
public class GameBoot extends JFrame implements ILaunch, IFinishWorld{

    /**
     * mapDao
     * the map which be loaded, from the database
     * @see IMap
     * */
    private IMap  mapDao = new MapDAO();
    private menu.Menu menu;
    private Engine engine;
    private Image icone;

    KeyboardFocusManager keyboardFocusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();

    private JPanel panelKeyEvent;

    /**
     * GameBoot
     * the constructor of the class. Here to initialize the window: set title, size, specifications, icon, engine and key events for the game
     * @see Engine
     * @see Menu
     * */
    GameBoot(){

        this.setTitle("BoulderDash");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try{
            icone = ImageIO.read(this.getClass().getResource("Character_waiting.png"));

        }catch (Exception e){
            System.err.println("load fail");
        }

        this.setIconImage(icone);

        menu = new menu.Menu(mapDao, this);


        engine = new Engine(this);

        this.add(menu);

        this.panelKeyEvent = this.menu;

        GameBoot self = this;
        this.keyboardFocusManager.addKeyEventDispatcher((KeyEvent e) -> {
                for (KeyListener keyListener: self.panelKeyEvent.getKeyListeners()) {
                    switch (e.getID()) {
                        case KeyEvent.KEY_PRESSED:
                            keyListener.keyPressed(e);
                            break;
                        case KeyEvent.KEY_RELEASED:
                            keyListener.keyReleased(e);
                            break;
                        case KeyEvent.KEY_TYPED:
                            keyListener.keyTyped(e);
                            break;
                    }
                }
                return true;
            });
    }
    /**
     * boot
     * show the window and resize it, thank to the engine
     * @see Engine
     * */
    void boot(){
        this.setVisible(true);
        engine.setSize(this.getSize());
    }

    @Override
    public void launch(String worldName) {
        try {
            World world = WorldLoader.getMap(worldName, mapDao, this.getSize());
            engine.loadWorld(world);
            this.remove(menu);
            this.add(engine);
            this.revalidate();
            this.repaint();
            this.panelKeyEvent = this.engine;
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void finished(boolean win) {
        if (win){
            this.menu.displayWin();
        } else {
            this.menu.displayLose();
        }
        this.remove(this.engine);
        this.add(this.menu);
        this.revalidate();
        this.repaint();
    }
}
