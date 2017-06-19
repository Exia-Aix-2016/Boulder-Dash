package model;

import dao.Dao;

import java.util.Observable;

public class Model extends Observable{

    private Dao dao;

    public Model(Dao dao){
        this.dao = dao;
    }

}
