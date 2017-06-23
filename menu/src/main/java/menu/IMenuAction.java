package menu;

interface IMenuAction {
    void exit();
    void home();
    void enterPlay();
    void playWorld(String worldName);
    void loadWorld();
    void displayWin();
    void displayLose();
}
