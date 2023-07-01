package persistance;

import model.drink.Drink;
import model.drink.DrinkLemonade;
import model.drink.DrinkWater;
import model.franchising.Franchising;
import model.franchising.FranchisingMug;
import model.franchising.FranchisingShirt;
import model.pizza.*;
import model.pizza.PizzaTopping;

import java.util.ArrayList;
import java.util.List;

public class DummyDB {

    private final List<Pizza> menuPizza = new ArrayList<>();
    private final List<PizzaTopping> menuTopping = new ArrayList<>();
    private final List<Drink> menuDrink = new ArrayList<>();
    private final List<Franchising> menuFranchising = new ArrayList<>();

    public List<Pizza> getMenuPizza() {
        return menuPizza;
    }

    public List<PizzaTopping> getMenuTopping() {
        return menuTopping;
    }

    public List<Drink> getMenuDrink() {
        return menuDrink;
    }

    public List<Franchising> getMenuFranchising() {
        return menuFranchising;
    }

    public void initDB() {
        menuPizza.add(new PizzaMargherita());
        menuPizza.add(new PizzaHawaiian());
        menuPizza.add(new PizzaSalami());
        menuPizza.add(new PizzaFamilySize(new PizzaMargherita()));

        menuDrink.add(new DrinkLemonade());
        menuDrink.add(new DrinkWater());

        menuFranchising.add(new FranchisingMug());
        menuFranchising.add(new FranchisingShirt());

    }

}
