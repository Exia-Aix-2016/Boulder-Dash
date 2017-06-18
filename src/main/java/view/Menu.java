package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

class Menu extends JPanel{

    private JPanel rootPanel;
    private JPanel worldsPanel;

    private JButton playButton;
    private JButton quitButton;
    private JButton backButton;

    private enum Panel{
        ROOT, WORLDS
    }

    private Panel currentPanel = Panel.ROOT;

    Image backgroundImage;

    Menu(){
        this.configurerootPanel();
        this.configureWorldsPanel();

        this.add(rootPanel, BorderLayout.CENTER);
        this.add(worldsPanel);
    }

    private void configurerootPanel(){
        this.rootPanel = new JPanel();
        this.rootPanel.setOpaque(false);

        this.playButton = new JButton("Play");
        this.quitButton = new JButton("Quit");

        this.rootPanel.add(playButton);
        this.rootPanel.add(quitButton);

        this.playButton.addActionListener((e -> this.swithPanel()));
        this.quitButton.addActionListener((e) -> System.exit(0));

        try {
            this.backgroundImage = ImageIO.read(this.getClass().getResource("menuBackground.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void configureWorldsPanel(){
        this.worldsPanel = new JPanel();
        this.worldsPanel.setOpaque(false);
        this.worldsPanel.setVisible(false);

        this.backButton = new JButton("Back");

        this.worldsPanel.add(new JButton("World1"));
        this.worldsPanel.add(new JButton("World2"));
        this.worldsPanel.add(this.backButton);

        this.backButton.addActionListener((e -> this.swithPanel()));

    }

    public void swithPanel(){
        switch (this.currentPanel){
            case ROOT:
                this.rootPanel.setVisible(false);
                this.worldsPanel.setVisible(true);
                this.currentPanel = Panel.WORLDS;
                break;
            case WORLDS:
                this.rootPanel.setVisible(true);
                this.worldsPanel.setVisible(false);
                this.currentPanel = Panel.ROOT;
                break;
        }
    }

    public void paintComponent(Graphics g) {
        g.drawImage(this.backgroundImage, 0, 0, this.getWidth(), this.getHeight(), null);
    }
}