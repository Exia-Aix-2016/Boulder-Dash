package menu;

import dao.IMap;

import java.util.ArrayList;

class WorldsPanel extends SubMenu {

    IMap mapDao;
    private int nbWorlds;

    WorldsPanel(IMenuAction menu, IMap madDao) {
        super(1, menu);

        this.mapDao = madDao;

        MButton backButton = new MButton("Back");

        ArrayList<MButton> worldsButtons = this.getWorldsButtons();

        for (MButton worldButton: worldsButtons){
            this.add(worldButton);
            worldButton.addActionListener((e -> this.menu.playWorld(worldButton.getText())));
        }

        this.add(backButton);
        backButton.addActionListener((e) -> this.menu.home());

        this.nbWorlds = worldsButtons.size() + 1;


        this.layout.setRows(nbWorlds);


    }

    private ArrayList<MButton> getWorldsButtons(){

        ArrayList<String> listWorldsNames = this.mapDao.getMapListNames();
        ArrayList<MButton> worldsButtons = new ArrayList<>();

        for (String worldName: listWorldsNames){
            worldsButtons.add(new MButton(worldName));
        }

        return worldsButtons;
    }
}
