package model;
import java.util.ArrayList;

public class Customer extends User {
  final private ArrayList<CartItem> cart;

  public Customer(String username, String email) {
    this(username, email, new ArrayList<>());
  }

  public Customer(String username, String email, ArrayList<CartItem> cart) {
    super(username, email, Tag.MODERATOR);
    this.cart = cart;
  }

  public void addItemToCart(Product item, int quantity) { this.cart.add(new CartItem(item.getId(), item.getProductName(), item.getProductPrice(), quantity)); }
  public void removeItemFromCart(int itemID) {
    this.cart.remove(itemID);
  }
  public void modifyItemQuantity(int itemID, int quantity) {
    this.cart.get(itemID).setCartItemQuantity(quantity);
  }
  public double getCartTotal() {return this.cart.stream().reduce(0.0, (sum, item) -> sum + item.getCartItemSubTotal(), Double::sum); }


  @Override
  public String toString() {
    return String.format("Customer(%s, cart=%s)", super.toString(), this.cart);
  }
}
