package view.menu;

class RootPanel extends SubMenu{

    private MButton playButton;
    private MButton quitButton;

    RootPanel(IMenuAction menu) {
        super(2, menu);

        playButton = new MButton("Play");
        quitButton = new MButton("Quit");

        this.add(playButton);
        this.add(quitButton);


        playButton.addActionListener((e -> this.menu.enterPlay()));
        quitButton.addActionListener((e) -> this.menu.exit());

    }
}
