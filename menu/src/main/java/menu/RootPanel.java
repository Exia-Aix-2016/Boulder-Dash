package menu;

class RootPanel extends SubMenu{

    private MButton playButton;
    private MButton quitButton;

    private MButton addWorldButton;

    RootPanel(IMenuAction menu) {
        super(2, menu);

        playButton = new MButton("Play");
        quitButton = new MButton("Quit");
        addWorldButton = new MButton("World loader");

        this.add(playButton);
        this.add(quitButton);
        this.add(addWorldButton);


        playButton.addActionListener((e -> this.menu.enterPlay()));
        quitButton.addActionListener((e) -> this.menu.exit());
        addWorldButton.addActionListener(e -> this.menu.loadWorld());

    }
}
