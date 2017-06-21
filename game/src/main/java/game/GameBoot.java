package game;

import dao.IMap;
import dao.MapDAO;
import engine.Engine;
import world.World;
import worldloader.WorldLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameBoot extends JFrame implements ILaunch{

    private IMap  mapDao = new MapDAO();
    private menu.Menu menu;
    private Engine engine;

    private Image icone = Toolkit.getDefaultToolkit().getImage("ressources\\Sprites\\Character\\Character_waiting.png");

    GameBoot(){

        this.setTitle("BoulderDash");
        this.setSize(new Dimension(800, 800));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        this.setIconImage(icone);

        menu = new menu.Menu(mapDao, this);
        engine = new Engine();

        this.add(menu);


    }

    void boot(){
        this.setVisible(true);
        engine.setSize(this.getSize());
    }

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

            JLabel backgroundDirt;
            try {
                backgroundDirt = new JLabel(new ImageIcon(ImageIO.read(this.getClass().getResource("backgroundDirt.jpg"))));

               // this.setContentPane(backgroundDirt);

            } catch (IOException e) {
                System.out.println("tqejfsjgsidgsiogsoighdihohood");
                e.printStackTrace();
            }



            this.repaint();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
