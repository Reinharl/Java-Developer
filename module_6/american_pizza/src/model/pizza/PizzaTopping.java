package model.pizza;

import model.pizza.Pizza;

public abstract class PizzaTopping implements Pizza {

    protected final Pizza pizza;

    public PizzaTopping(Pizza pizza) {
        this.pizza = pizza;

    }

}
