package model;

import model.product.FoodProduct;
import model.product.Product;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Market {

    private static final int MAX_SIZE = 100;

    private List<Product> products;
    private int size;

    // no args constructor
    public Market() {
        products = new ArrayList<>();
        size = 0;
    }

    // getter & setter
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean addProduct(Product product) {
        int quantity = product.getQuantity();

        if (size + quantity <= MAX_SIZE) {

            for (Product value : products) {
                if (value.equals(product)) {
                    value.setQuantity(value.getQuantity() + quantity);
                    size += quantity;
                    System.out.println("Added " + quantity + " to the product: " + product.getName());
                    return true;
                }
            }

            products.add(product);
            size += quantity;
            System.out.println("Added: " + product);
            return true;
        }

        System.out.println("Product quantity exceeds Market max size");
        return false;
    }

    public boolean removeProduct(Product product) {
        int quantity = product.getQuantity();

        int index = products.indexOf(product);

        if (index != -1) {
            if (products.get(index).getQuantity() - quantity < 0) {
                System.out.println("Product quantity not available");
                return false;
            } else if (products.get(index).getQuantity() - quantity == 0) {
                products.remove(product);
                System.out.println("Removed: " + product);
                size -= quantity;
                return true;
            } else {
                products.get(index).setQuantity(products.get(index).getQuantity() - product.getQuantity());
                size -= quantity;
                System.out.println("Removed " + quantity + " to the product: " + product.getName());
                return true;
            }
        }

        System.out.println("Product not found");
        return false;
    }

    public Integer purchase(Cart cart, User user) {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        int total = 0;

        for (Product product : cart.getProducts()) {
            if (removeProduct(product)) {
                if (product instanceof FoodProduct && user.ageIsOver(60) &&
                        (day == Calendar.MONDAY || day == Calendar.WEDNESDAY)) {
                    total += Math.round(product.getPrice() * 0.8);
                } else {
                    total += product.getPrice();
                }
            } else {
                System.out.println("Purchase failed");
                return null;
            }
        }

        System.out.println("Total price: " + total / 100.0);
        return total;
    }

    public Integer installmentPayment(int numberOfMonth, int total) {
        int monthly = total / numberOfMonth;

        System.out.println("3 months of: " + monthly / 100.0);
        return monthly;
    }

    public int calculateGiftPoints(User user, int total) {
        int giftPoints = total / 1000;

        user.setGiftPoints(user.getGiftPoints() + giftPoints);

        System.out.println("Added: " + giftPoints + " gift points to user: " + user.getName());
        return giftPoints;
    }

    public int useGiftPoints(User user, int total) {
        int giftPoints = user.getGiftPoints();

        while (giftPoints >= 10) {
            if (total >= 1) {
                total -= 100;
                giftPoints -= 10;
            } else {
                user.setGiftPoints(giftPoints);
                break;
            }
        }

        user.setGiftPoints(giftPoints);
        return total;
    }

    @Override
    public String toString() {
        return "Market{" +
                "products=" + products +
                ", size=" + size +
                '}';
    }
}
