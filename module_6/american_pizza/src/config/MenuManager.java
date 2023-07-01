package config;

import model.drink.Drink;
import model.franchising.Franchising;
import model.pizza.Pizza;
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
