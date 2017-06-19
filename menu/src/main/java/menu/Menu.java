package menu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Menu extends JPanel implements IMenuAction{

    private JPanel rootPanel;
    private JPanel worldsPanel;

    private Image backgroundImage;

    public Menu(){
        this.setLayout(new GridBagLayout());

        try {
            this.backgroundImage = ImageIO.read(this.getClass().getResource("background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.rootPanel = new RootPanel(this);
        this.worldsPanel = new WorldsPanel(this);

        this.setPanel(this.rootPanel);
    }

    private void setPanel(JPanel panel){
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
        this.setPanel(worldsPanel);
    }
}