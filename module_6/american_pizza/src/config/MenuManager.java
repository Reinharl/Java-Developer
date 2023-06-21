package config;

import model.Drink;
import model.Franchising;
import model.Pizza;
import model.PizzaTopping;
import persistance.DummyDB;

public class MenuManager {

    DummyDB dummyDB;

    public MenuManager() {
        dummyDB = new DummyDB();
        dummyDB.initDB();
    }

    public void printMenu() {
        System.out.println("**** PRINT MENU ****");

        for (Pizza pizza : dummyDB.getMenuPizza()) {
            System.out.println(pizza.getMenuItemLine());
        }

        System.out.println();

        for (Drink drink : dummyDB.getMenuDrink()) {
            System.out.println(drink.getMenuItemLine());
        }

        System.out.println();

        for (Franchising franchising : dummyDB.getMenuFranchising()) {
            System.out.println(franchising.getMenuItemLine());
        }

    }

}
