package menu;

import dao.IMap;
import worldloader.WorldLoader;

interface IMenuAction {
    void exit();
    void home();
    void enterPlay();
    void playWorld(String worldName);
    void loadWorld();
}
