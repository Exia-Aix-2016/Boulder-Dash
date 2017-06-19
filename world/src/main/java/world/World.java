package world;

import world.elements.block.Block;
import world.elements.entity.Entity;
import world.elements.entity.Character;

import java.util.ArrayList;
import java.util.Date;

public class World {
    private String name;
    private Dimension dimension;
    private int score;
    private int diamonds_left;
    private Date startTime;
    private ArrayList<Entity> entities;
    private ArrayList<Block> blocks;
    private Character character;

    public World(String name, Dimension dimension, int diamonds_left){
        this.name = name;
        this. dimension = dimension;
        this.diamonds_left = diamonds_left;

        this.entities = new ArrayList<>();
        this.blocks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addEntity(Entity entity){
        if(entity instanceof Character){
            this.character = (Character) entity;
        }else{
            this.entities.add(entity);
        }
    }

    public void addBlock (Block block){
        this.blocks.add(block);
    }


}
