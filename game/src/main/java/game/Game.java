package game;

import dao.Dao;
import menu.Menu;

import javax.swing.*;
import java.awt.*;

public class Game {

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setTitle("BoulderDash");
        frame.setSize(new Dimension(800, 800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Menu menu = new Menu();

        frame.add(menu);

        frame.setVisible(true);
    }
}
