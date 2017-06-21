package world.elements.entity.movable;

import world.elements.entity.StateType;

public class SpriteEngine {
    private String[]sprites;


    SpriteEngine(String sprite1, String sprite2){
       this.sprites[0] = sprite1;
       this.sprites[1] = sprite2;

    }

    private String getSprite(int step){
        return this.sprites[step];
    }



}
