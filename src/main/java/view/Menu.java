package view;

import javax.swing.*;

class Menu extends JPanel{

    JPanel rootPanel;
    JPanel worldsPanel;

    JButton playButton;
    JButton quitButton;
    JButton backButton;

    private enum Panel{
        ROOT, WORLDS
    }

    private Panel currentPanel = Panel.ROOT;

    Menu(){
        this.configurerootPanel();
        this.configureWorldsPanel();

        this.add(rootPanel);
        this.add(worldsPanel);
    }

    private void configurerootPanel(){
        this.rootPanel = new JPanel();

        this.playButton = new JButton("Play");
        this.quitButton = new JButton("Quit");

        this.rootPanel.add(playButton);
        this.rootPanel.add(quitButton);

        this.playButton.addActionListener((e -> this.swithPanel()));
        this.quitButton.addActionListener((e) -> System.exit(0));
    }

    private void configureWorldsPanel(){
        this.worldsPanel = new JPanel();
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
}