import model.Cart;
import model.Market;
import model.User;
import model.product.FoodProduct;
import model.product.GenericProduct;
import model.product.Product;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Product product1 = new FoodProduct("Mela", 299, 30);
        Product product2 = new FoodProduct("Pera", 200, 30);
        Product product3 = new GenericProduct("Shampoo", 889, 30);
        Product product4 = new GenericProduct("Perle", 49900, 30);

        Market market = new Market();
        System.out.println(market.addProduct(product1));
        System.out.println(market.addProduct(product2));
        System.out.println(market.addProduct(product3));
        System.out.println(!market.addProduct(product4));

        Product product5 = new FoodProduct("Mela", 299, 10);
        System.out.println(market.addProduct(product5));

        Product product6 = new FoodProduct("Mela", 299, 20);
        System.out.println(market.removeProduct(product6));

        Product product7 = new FoodProduct("Pera", 200, 30);
        System.out.println(market.removeProduct(product7));

        Product product8 = new FoodProduct("Pera", 200, 30);
        System.out.println(!market.removeProduct(product8));

        Product product9 = new FoodProduct("Shampoo", 889, 40);
        System.out.println(!market.removeProduct(product9));

        System.out.println("Market = " + market);

        Cart cart = new Cart(List.of(
                new FoodProduct("Mela", 299, 1),
                new GenericProduct("Shampoo", 889, 1)
        ));
        User user = new User("Mario Rossi", 60);

        int totalPrice = market.purchase(cart, user);
        System.out.println(totalPrice == 1188);
        System.out.println(market.installmentPayment(3, totalPrice) == 396);

        System.out.println(market.calculateGiftPoints(user, totalPrice) == 1);

        user.setGiftPoints(25);
        System.out.println(market.useGiftPoints(user, totalPrice) == 988);
    }
}
