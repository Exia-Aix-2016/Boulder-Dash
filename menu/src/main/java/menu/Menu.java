package menu;

import dao.IMap;
import game.ILaunch;
import javafx.stage.FileChooser;
import world.World;
import worldloader.WorldLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Menu extends JPanel implements IMenuAction {

    private JPanel rootPanel;
    private JPanel worldsPanel;

    private Image backgroundImage;
    private IMap mapDao;
    private ILaunch worldLaucher;

    public Menu(IMap mapDao, ILaunch worldLauncher) {

        this.mapDao = mapDao;
        this.worldLaucher = worldLauncher;

        this.setLayout(new GridBagLayout());

        try {
            this.backgroundImage = ImageIO.read(this.getClass().getResource("background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.rootPanel = new RootPanel(this);


        this.setPanel(this.rootPanel);
    }

    private void setPanel(JPanel panel) {
        this.removeAll();
        this.add(panel);
        this.revalidate();
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        g.drawImage(this.backgroundImage, 0, 0, this.getWidth(), this.getHeight(), null);
    }

    @Override
    public void exit() {
        System.exit(0);
    }

    @Override
    public void home() {
        this.setPanel(rootPanel);
    }

    @Override
    public void enterPlay() {
        this.worldsPanel = new WorldsPanel(this, mapDao);
        this.setPanel(worldsPanel);
    }

    @Override
    public void playWorld(String worldName) {
        this.worldLaucher.launch(worldName);
    }

    @Override
    public void loadWorld() {
        FileSystemView vueSysteme = FileSystemView.getFileSystemView();

        File defaut = vueSysteme.getDefaultDirectory();

        JFileChooser fileChooser = new JFileChooser(defaut);
        fileChooser.showOpenDialog(null);

        File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

        System.out.println(file.getAbsolutePath());

        try {

            this.mapDao.addMap(WorldLoader.genRawMapFILE(file));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}