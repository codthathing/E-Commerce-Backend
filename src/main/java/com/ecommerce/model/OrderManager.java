package model;
import enums.OrderStatus;
import exceptions.InsufficientStock;
import exceptions.UserCartNotFound;
import exceptions.UserOrderNotFound;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderManager {
  HashMap<String, Order> orders;

  public void placeOrder(String customerId) {
    if (ShoppingCart.carts.containsKey(customerId)) {
      ArrayList<CartItem> cart = ShoppingCart.carts.get(customerId);

      for (CartItem item : cart) {
        Product currentProduct = ProductCatalog.searchProduct(item.getCartItemProduct().getProductName());

        if (currentProduct.getProductStock() < item.getCartItemQuantity()) {
          throw new InsufficientStock(String.format("Insufficient stock for %s, %d item(s) left in stock kindly adjust cart item", currentProduct.getProductName(), currentProduct.getProductStock()));
        }

        currentProduct.updateProductStock(currentProduct.getProductStock() - item.getCartItemQuantity());
      }

      Order newOrder = new Order(cart);

      orders.put(customerId, newOrder);
      ShoppingCart.carts.remove(customerId);
    } else {
      throw new UserCartNotFound("User cart does not exists!");
    }
  }

  public void updateOrderStatus(String customerId, OrderStatus orderStatus) {
    if (orders.containsKey(customerId)) {
      orders.get(customerId).updateOrderStatus(orderStatus);
    } else {
      throw new UserOrderNotFound("User order does not exists!");
    }
  }
}
