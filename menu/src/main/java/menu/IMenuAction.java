package menu;

import java.io.File;

interface IMenuAction {
    void exit();
    void home();
    void enterPlay();
    void playWorld(String worldName);
    File loadWorld();
}
