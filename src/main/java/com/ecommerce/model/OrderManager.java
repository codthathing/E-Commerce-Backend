package model;
import java.util.HashMap;

public class OrderManager {
  HashMap<String, Order> orders;

  public void placeOrder(String customerId) {
    if (ShoppingCart.carts.containsKey(customerId)) {
      Order currentCart = new Order(ShoppingCart.carts.get(customerId));

      orders.put(customerId, currentCart);
      ShoppingCart.carts.remove(customerId);
    }
  }
}
