package game;

import menu.Menu;

import javax.swing.*;
import java.awt.*;

public class Game {

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setTitle("BoulderDash");
        frame.setPreferredSize(new Dimension(800, 800));

        Menu menu = new Menu();

        frame.add(menu);

        frame.setVisible(true);
    }
}
