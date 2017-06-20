package worldloader;

import dao.*;
import world.Dimension;
import world.ICreateWorld;
import world.Position;
import world.World;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Optional;
import java.util.Scanner;

/**
 * WorldLoader will can use IMap (DAO) to load a RawMap (which a sql representation of a world)
 * @see dao
 *
 */
public abstract class WorldLoader {

    private static ICreateWorld world = null;

    /**
     * Allow to get map with her name
     *
     * @param nameMap name of map you can load
     * @param MapDAO  DAO which allow to search the map in database
     * @return a Optional(ICreateWorld interface between WorldLoader and World)
     * @see ICreateWorld
     * @see world
     * @see Optional
     */
    public static World getMap(final String nameMap, IMap MapDAO) throws Exception {

        Optional<RawMap> rawMap = MapDAO.getMap(nameMap);

        if (rawMap.isPresent()) {
            return WorldLoader.genWorld(rawMap.get());
        } else {
            throw new Exception("Error of map loading");
        }
    }

    /**
     * It's used by getWorld to create the world
     *
     * @param rawMap its a representation of database Map
     */
    private static World genWorld(final RawMap rawMap) {

        Dimension dimension = new Dimension(rawMap.getWidth(), rawMap.getHeight());

        ICreateWorld world = new World(rawMap.getName(), dimension, rawMap.getNbrDiamond(), rawMap.getTimeRemaining());

        for (RawElement element : rawMap.getElements()) {
            switch (element.getObjectType()) {
                case CHARACTER:
                    world.addEntity(FactoryElement.getNewCharacter(
                            new Position(element.getX(), element.getY()),
                            new Dimension(16, 16)));
                    break;
                case MONSTER:
                    world.addEntity(FactoryElement.getNewMonster(
                            new Position(element.getX(), element.getY()),
                            new Dimension(16, 16)));
                    break;
                case DIAMOND:
                    world.addEntity(FactoryElement.getNewDiamond(
                            new Position(element.getX(), element.getY()),
                            new Dimension(16, 16)));
                    break;
                case ROCK:
                    world.addEntity(FactoryElement.getNewRock(
                            new Position(element.getX(), element.getY()),
                            new Dimension(16, 16)));
                    break;
                case WALL:
                    world.addBlock(FactoryElement.getNewWall(
                            new Position(element.getX(), element.getY()),
                            new Dimension(16, 16)));
                    break;
                case DIRT:
                    world.addBlock(FactoryElement.getNewDirt(
                            new Position(element.getX(), element.getY()),
                            new Dimension(16, 16)));
                    break;
            }
        }
        return (World) world;
    }


    /**
     * With a file this method can generate a RawMap which will send in dataBase.
     * @param file File of the map
     *  @return RawMap representation of the world
     *  @throws Exception send exeption when readFile fail.
     * */
    public static RawMap genRawMapFILE(final File file) throws Exception {

        String mapName = file.getName();
        mapName = mapName.substring(0, mapName.lastIndexOf('.'));

        Integer width = 0;
        Integer height = 0;
        Integer nbrDiamond = 0;
        Integer timeRemaining = 0;
        RawMap rawMap = null;
        Scanner scanner;
        String line;
        int y = 0;


        try {
            scanner = new Scanner(file);

            width = Integer.valueOf(scanner.nextLine());
            height = Integer.valueOf(scanner.nextLine());
            nbrDiamond = Integer.valueOf(scanner.nextLine());
            timeRemaining = Integer.valueOf(scanner.nextLine());


            if (width == null || height == null || nbrDiamond == null || timeRemaining == null) {
                throw new Exception(" WorldLoader : Impossible to read width, height, number of diamond or timeRemaining");
            } else {
                rawMap = new RawMap(mapName, width, height, nbrDiamond, timeRemaining);
                while (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                    for (int i = 0; i < line.length(); i++) {

                        switch (line.charAt(i)) {
                            case 'C':
                                rawMap.addElement(new RawElement(ObjectType.CHARACTER, i, y));
                                break;
                            case 'M':
                                rawMap.addElement(new RawElement(ObjectType.MONSTER, i, y));
                                break;
                            case 'D':
                                rawMap.addElement(new RawElement(ObjectType.DIAMOND, i, y));
                                break;
                            case 'X':
                                rawMap.addElement(new RawElement(ObjectType.DIRT, i, y));
                                break;
                            case 'W':
                                rawMap.addElement(new RawElement(ObjectType.WALL, i, y));
                                break;
                            case 'R':
                                rawMap.addElement(new RawElement(ObjectType.ROCK, i, y));
                                break;
                            case 'E':
                                rawMap.addElement(new RawElement(ObjectType.EXIT, i, y));
                        }
                    }
                    y++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return rawMap;
    }

    public static void SendToDataBase(final RawMap rawMap, IMap MapDAO){
        MapDAO.addMap(rawMap);
    }
}



