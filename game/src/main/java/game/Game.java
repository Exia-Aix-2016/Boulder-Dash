package game;

import dao.IMap;
import dao.MapDAO;
import menu.Menu;

import javax.swing.*;
import java.awt.*;

public class Game {

    public static void main(String[] args) {
        GameBoot gameBoot = new GameBoot();

        gameBoot.boot();
    }
}
