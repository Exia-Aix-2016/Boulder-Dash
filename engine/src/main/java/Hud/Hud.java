package Hud;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;

/**
 * The HUD allow to display the information to user
 * @see Info
 * @see JPanel
 */
public class Hud extends JPanel{
    ArrayList<Info> infos;
    public Hud(GridLayout gridLayout){

        this.infos = new ArrayList<>();
         this.setLayout(gridLayout);

    }

    /**
     * Allow to add information in HUD
     * @param info the Info you want add
     * @see Info
     * */
    public void addInfo(Info info){
        this.infos.add(info);
        this.add(info);
    }

    /**
     * Allow to get the info with it name
     * @return Optional(Info) if the info not exist return Optional(Info)
     * @param name name of info displayed
     * */
    public Optional<Info> getInfo(final String name){
        for(Info info : this.infos){
            if(info.getName().equalsIgnoreCase(name)){
                return Optional.of(info);
            }
        }
        return Optional.empty();
    }
}
