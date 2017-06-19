package menu;

import javax.swing.*;
import java.awt.*;

abstract class SubMenu extends JPanel {

    protected IMenuAction menu;

    SubMenu(int rows, IMenuAction menu){
        this.menu = menu;

        this.setOpaque(false);

        GridLayout layout = new GridLayout();
        layout.setHgap(20);
        layout.setVgap(20);
        layout.setColumns(1);
        layout.setRows(rows);

        this.setLayout(layout);
    }
}
