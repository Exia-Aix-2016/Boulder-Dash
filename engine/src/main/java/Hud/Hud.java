package Hud;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 */
public class Hud extends JPanel{
    ArrayList<Info> infos;
    public Hud(GridLayout gridLayout){

        this.infos = new ArrayList<>();
         this.setLayout(gridLayout);

    }

    public void addInfo(Info info){
        this.infos.add(info);
        this.add(info);
    }

    public Optional<Info> getInfo(final String name){
        for(Info info : this.infos){
            if(info.getName().equalsIgnoreCase(name)){
                return Optional.of(info);
            }
        }
        return Optional.empty();
    }
}
