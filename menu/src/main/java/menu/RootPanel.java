package menu;

import javax.swing.*;

class RootPanel extends SubMenu{

    private MButton playButton;
    private MButton quitButton;

    private MButton addWorldButton;

    RootPanel(IMenuAction menu) {
        super(3, menu);

        playButton = new MButton("Play");
        addWorldButton = new MButton("World loader");
        quitButton = new MButton("Quit");

        this.add(playButton);
        this.add(addWorldButton);
        this.add(quitButton);





        playButton.addActionListener((e -> this.menu.enterPlay()));
        addWorldButton.addActionListener(e -> this.menu.loadWorld());
        quitButton.addActionListener((e) -> this.menu.exit());


    }
}
