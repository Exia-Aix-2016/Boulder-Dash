package menu;

import javax.swing.*;
import java.awt.*;

class MButton extends JButton {

    MButton(String text){
        this.setText(text);
        this.setPreferredSize(new Dimension(400, 150));
        this.setFont(new Font("Ravie", Font.PLAIN, 40));
        this.setBackground(Color.decode("#62DC62"));
        this.setForeground(Color.decode("#F6F6F6"));
        this.setFocusPainted(false);
    }

}
