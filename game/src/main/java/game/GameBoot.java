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
 * TODO
 * */
public class GameBoot extends JFrame implements ILaunch{

    private IMap  mapDao = new MapDAO();
    private menu.Menu menu;
    private Engine engine;
    /**
     * TODO
     * */
    private Image icone;

    KeyboardFocusManager keyboardFocusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();

    private JPanel panelKeyEvent;
    /**
     * TODO
     * */
    GameBoot(){

        this.setTitle("BoulderDash");
        this.setSize(new Dimension(800, 800));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try{
            icone = ImageIO.read(this.getClass().getResource("Character_waiting.png"));

        }catch (Exception e){
            System.out.println("load fail");
        }

        this.setIconImage(icone);

        menu = new menu.Menu(mapDao, this);
        engine = new Engine();

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
     * TODO
     * */
    void boot(){
        this.setVisible(true);
        engine.setSize(this.getSize());
    }
    /**
     * TODO
     * */
    @Override
    public void launch(String worldName) {
        System.out.println("Launching world: " + worldName);
        try {
            World world = WorldLoader.getMap(worldName, mapDao, this.getSize());
            System.out.println(world);
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
}
