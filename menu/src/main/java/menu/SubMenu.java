package menu;

import javax.swing.*;
import java.awt.*;

abstract class SubMenu extends JPanel {

    protected IMenuAction menu;

    protected GridLayout layout;

    SubMenu(int rows, IMenuAction menu){
        this.menu = menu;

        this.setOpaque(false);

        this.layout = new GridLayout();
        this.layout.setHgap(20);
        this.layout.setVgap(20);
        this.layout.setColumns(1);
        this.layout.setRows(rows);

        this.setLayout(this.layout);
    }
}

