package game;

import dao.IMap;
import dao.MapDAO;
import engine.Engine;

import javax.swing.*;
import java.awt.*;

public class GameBoot extends JFrame implements ILaunch{

    private IMap  mapDao = new MapDAO();
    private menu.Menu menu;
    private Engine engine;

    GameBoot(){

        this.setTitle("BoulderDash");
        this.setSize(new Dimension(800, 800));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menu = new menu.Menu(mapDao, this);
        engine = new Engine();

        this.add(menu);
    }

    public void boot(){
        this.setVisible(true);
    }

    @Override
    public void launch(String worldName) {
        System.out.println("Launching world: " + worldName);
        this.remove(menu);
        this.add(engine);
        this.revalidate();
        this.repaint();
    }
}
