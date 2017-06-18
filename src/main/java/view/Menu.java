package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

class Menu extends JPanel{

    private JPanel rootPanel;
    private JPanel worldsPanel;

    private Image backgroundImage;

    Menu(){
        this.configurerootPanel();
        this.configureWorldsPanel();

        try {
            this.backgroundImage = ImageIO.read(this.getClass().getResource("menuBackground.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setPanel(this.rootPanel);
    }

    private void configurerootPanel(){
        this.rootPanel = new JPanel();
        this.rootPanel.setOpaque(false);

        JButton playButton = new JButton("Play");
        JButton quitButton = new JButton("Quit");

        this.rootPanel.setSize(new Dimension(400,400));

        this.rootPanel.setLayout(new GridLayout(2, 1, 20, 20));

        this.rootPanel.add(playButton);
        this.rootPanel.add(quitButton);

        playButton.addActionListener((e -> this.setPanel(this.worldsPanel)));
        quitButton.addActionListener((e) -> System.exit(0));
    }

    private void configureWorldsPanel(){
        this.worldsPanel = new JPanel();
        this.worldsPanel.setOpaque(false);

        JButton backButton = new JButton("Back");

        this.worldsPanel.setLayout(new GridLayout(3, 1, 20, 20));

        this.worldsPanel.add(new JButton("World1"));
        this.worldsPanel.add(new JButton("World2"));
        this.worldsPanel.add(backButton);

        backButton.addActionListener((e -> this.setPanel(this.rootPanel)));
    }

    private void setPanel(JPanel panel){
        this.removeAll();
        System.out.println(this.getSize());
        System.out.println(panel.getSize());
        this.add(panel, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        g.drawImage(this.backgroundImage, 0, 0, this.getWidth(), this.getHeight(), null);
    }
}