package menu;

class WorldsPanel extends SubMenu {

    WorldsPanel(IMenuAction menu) {
        super(3, menu);

        MButton backButton = new MButton("Back");

        this.add(new MButton("World 1"));
        this.add(new MButton("World 2"));
        this.add(backButton);

        backButton.addActionListener((e) -> { this.menu.home(); });
    }
}
