package world;

import world.elements.block.Block;
import world.elements.entity.Character;
import world.elements.entity.Entity;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * World
 * object were are stocked every informations needed to diplay a world on the window
 * @see ICreateWorld
 * @see world.IWorld
 * */

public class World implements ICreateWorld, IWorld {
    private String name;
    private Dimension dimension;
    private int score;
    private int diamonds_left;
    private Date startTime;
    private ArrayList<Entity> entities;
    private ArrayList<Block> blocks;
    private Character character;

    private int timeRemaining;

    /**
     * World
     * The constructor of the class, called to creat a new world. Composed mainly of two arrayList, which contain the elements of the world
     * @see Dimension
     * */

    public World(String name, Dimension dimension, int diamonds_left, int timeRemaining){
        this.name = name;
        this. dimension = dimension;
        this.diamonds_left = diamonds_left;
        this.timeRemaining = timeRemaining;

        this.entities = new ArrayList<>();
        this.blocks = new ArrayList<>();
    }
    /**
     * TODO
     * */
    public String getName() {
        return name;
    }
    /**
     * TODO
     * */
    public int getTimeRemaining() {
        return timeRemaining;
    }

    @Override
    public Dimension getDimension() {
        return dimension;
    }

    @Override
    public void removeEntity(IComponent element) {
        this.entities.remove(element);
    }

    @Override
    public void removeBlock(IComponent element) {
        this.blocks.remove(element);
    }

    @Override
    public void removeCharacter(IComponent element) {
        this.character = null;
    }

    /**
     * TODO
     * */
    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    /**
     * getEntitties
     * Needed for get the entities which compose the world
     * @return  IEntity
     * */

    public ArrayList<IEntity> getEntities() {
        ArrayList<IEntity> r = new ArrayList<>();
        r.addAll(entities);
        r.add(character);
        return r;
    }
    /**
     * TODO
     * */
    public Character getCharacter() {
        return character;
    }
    /**
     * TODO
     * */
    public Date getStartTime() {
        return startTime;
    }
    /**
     * TODO
     * */
    public int getDiamonds_left() {
        return diamonds_left;
    }
    /**
     * TODO
     * */
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


    @Override
    public IControllable getControllable() {
        return null;
    }

    @Override
    public Collection<IComponent> getComponents() {
        Collection<IComponent> components = new ArrayList<>();
        components.addAll(blocks);
        components.addAll(entities);
        if (character != null){
            components.add(character);
        }
        return components;
    }
}
