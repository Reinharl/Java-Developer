package model;

import model.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> products;

    // no args constructor
    public Cart() {
        products = new ArrayList<>();
    }

    // all args constructor
    public Cart(List<Product> products) {
        this.products = products;
    }

    // getter & setter
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "products=" + products +
                '}';
    }
}
