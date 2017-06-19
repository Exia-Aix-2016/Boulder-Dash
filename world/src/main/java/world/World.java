package world;

import world.elements.block.Block;
import world.elements.entity.Entity;
import world.elements.entity.Character;

import java.util.ArrayList;
import java.util.Date;

public class World implements ICreateWorld {
    private String name;
    private Dimension dimension;
    private int score;
    private int diamonds_left;
    private Date startTime;
    private ArrayList<Entity> entities;
    private ArrayList<Block> blocks;
    private Character character;

    private int timeRemaining;

    public World(String name, Dimension dimension, int diamonds_left, int timeRemaining){
        this.name = name;
        this. dimension = dimension;
        this.diamonds_left = diamonds_left;
        this.timeRemaining = timeRemaining;

        this.entities = new ArrayList<>();
        this.blocks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public Character getCharacter() {
        return character;
    }

    public Date getStartTime() {
        return startTime;
    }

    public int getDiamonds_left() {
        return diamonds_left;
    }

    public int getScore() {
        return score;
    }

    @Override
    public void addEntity(Entity entity){
        if(entity instanceof Character){
            this.character = (Character) entity;
        }else{
            this.entities.add(entity);
        }
    }

    @Override
    public void addBlock (Block block){
        this.blocks.add(block);
    }


}
