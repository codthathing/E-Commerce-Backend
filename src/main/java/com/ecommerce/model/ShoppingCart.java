package model;
import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCart {
  public static HashMap<String, ArrayList<CartItem>> carts;

  public void addItemToCart(String customerId, Boolean canModerate, Product item, int quantity) {
    if (carts.containsKey(customerId) && canModerate) {
      ArrayList<CartItem> cartItems = carts.get(customerId);
      cartItems.add(new CartItem(item.getId(), item.getProductName(), item.getProductPrice(), quantity));
    } else if (!carts.containsKey(customerId) && canModerate)  {
      ArrayList<CartItem> cartItems = new ArrayList<>();
      cartItems.add(new CartItem(item.getId(), item.getProductName(), item.getProductPrice(), quantity));

      carts.put(customerId, cartItems);
    }
  }

  public void removeItemFromCart(String customerId, Boolean canModerate, int itemId) {
    if (carts.containsKey(customerId) && canModerate) {
      carts.get(customerId).remove(itemId);
    }
  }

  public void modifyItemQuantity(String customerId, Boolean canModerate, int itemId, int quantity) {
    if (carts.containsKey(customerId) && canModerate) {
      carts.get(customerId).get(itemId).setCartItemQuantity(quantity);
    }
  }

  public double getCartTotal(String customerId, Boolean canModerate) {
    if (carts.containsKey(customerId) && canModerate) {
      ArrayList<CartItem> cartItems = carts.get(customerId);

      return cartItems.stream().reduce(0.0, (sum, item) -> sum + item.getCartItemSubTotal(), Double::sum);
    }

    return 0;
  }
}
