package main;

import controller.Controller;
import dao.Dao;
import model.Model;
import view.View;

public class BoulderDash {
    public static void main(String[] args) {

        System.out.println("BOULDERDASH");

        Dao dao = Dao.getInstance();

        Model model = new Model(dao);
        Controller controller = new Controller(model);

        View view = new View(model);
    }
}
