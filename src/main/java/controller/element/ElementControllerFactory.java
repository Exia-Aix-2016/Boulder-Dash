package controller.element;

import model.elements.Element;

public abstract class ElementControllerFactory {

    public static ElementController createPlayerController(Element player){
        return new PlayerController(player);
    }

    public static ElementController createMonsterController(Element monster){
        return new MonsterController(monster);
    }

    public static ElementController createDiamondController(Element diamond){
        return new DiamondController(diamond);
    }

    public static ElementController createRockController(Element rock){
        return new RockController(rock);
    }
}
