package worldloader;

import dao.IMap;
import dao.ObjectType;
import dao.RawElement;
import dao.RawMap;
import world.ICreateWorld;
import world.Position;
import world.World;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

/**
 * WorldLoader will can use IMap (DAO) to load a RawMap (which a sql representation of a world)
 * @see dao
 *
 */
public abstract class WorldLoader {

    /**
     * Allow to get map with its name
     * @param nameMap name of map you can load
     * @param MapDAO  DAO which allow to search the map in database
     * @param screenSize screen size
     * @return a Optional(ICreateWorld interface between WorldLoader and World)
     * @see ICreateWorld
     * @see world
     * @see Optional
     * */
    public static World getMap(final String nameMap, IMap MapDAO, Dimension screenSize) throws Exception{

        Optional<RawMap> rawMapO = MapDAO.getMap(nameMap);

        if (rawMapO.isPresent()){
            RawMap rawMap = rawMapO.get();

            Dimension dimension = new Dimension(rawMap.getWidth(), rawMap.getHeight());

            int ratioW = screenSize.width / dimension.width;
            int ratioH = screenSize.height / dimension.height;

            int elementSize = ratioW < ratioH ? ratioW : ratioH;

            Dimension elementDimension = new Dimension(elementSize, elementSize);

            ICreateWorld world = new World(rawMap.getName(), dimension, rawMap.getNbrDiamond(), rawMap.getTimeRemaining());

            for (RawElement element : rawMap.getElements()){
                switch (element.getObjectType()){
                    case CHARACTER:
                        world.addEntity(FactoryElement.getNewCharacter(
                                new Position(element.getX() * elementSize, element.getY() * elementSize),
                                new Dimension(elementDimension)));
                        break;
                    case MONSTER:
                        world.addEntity(FactoryElement.getNewMonster(
                                new Position(element.getX() * elementSize, element.getY() * elementSize),
                                new Dimension(elementDimension)));
                        break;
                    case DIAMOND:
                        world.addEntity(FactoryElement.getNewDiamond(
                                new Position(element.getX() * elementSize, element.getY() * elementSize),
                                new Dimension(elementDimension)));
                        break;
                    case ROCK:
                        world.addEntity(FactoryElement.getNewRock(
                                new Position(element.getX() * elementSize, element.getY() * elementSize),
                                new Dimension(elementDimension)));
                        break;
                    case WALL:
                        world.addBlock(FactoryElement.getNewWall(
                                new Position(element.getX() * elementSize, element.getY() * elementSize),
                                new Dimension(elementDimension)));
                        break;
                    case DIRT:
                        world.addBlock(FactoryElement.getNewDirt(
                                new Position(element.getX() * elementSize, element.getY() * elementSize),
                                new Dimension(elementDimension)));
                        break;
                    case EXIT:
                        world.addBlock(FactoryElement.getNewExit(
                                new Position(element.getX() * elementSize, element.getY() * elementSize),
                                new Dimension(elementDimension)));
                }
            }
            return (World) world;
        } else {
            throw new Exception("Error of map loading");
        }
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
}



