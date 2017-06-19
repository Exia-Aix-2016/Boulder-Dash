package menu;

import java.util.ArrayList;

class WorldsPanel extends SubMenu {

    WorldsPanel(IMenuAction menu) {
        super(3, menu);

        MButton backButton = new MButton("Back");

        ArrayList<MButton> worldsButtons = this.getWorldsButtons();

        this.add(new MButton("World 1"));
        this.add(new MButton("World 2"));
        this.add(backButton);

        backButton.addActionListener((e) -> { this.menu.home(); });
    }

    private ArrayList<MButton> getWorldsButtons(){
        ArrayList<MButton> worldsButtons = new ArrayList<>();

        return worldsButtons;
    }
}
