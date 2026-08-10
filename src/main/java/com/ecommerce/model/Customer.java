package model;
import java.util.ArrayList;

public class Customer extends User {
  final private ArrayList<CartItem> cart;
  final private ArrayList<Product> wishlist;

  public Customer(String username, String email) {
    this(username, email, new ArrayList<>(), new ArrayList<>());
  }

  public Customer(String username, String email, ArrayList<CartItem> cart, ArrayList<Product> wishlist) {
    super(username, email, Tag.MODERATOR);
    this.cart = new ArrayList<>(cart);
    this.wishlist = new ArrayList<>(wishlist);
  }

  public void addItemToCart(CartItem item) {
    cart.add(item);
  }

  public void addProductToWishlist(Product product) {
    wishlist.add(product);
  }

  @Override
  public String toString() {
    return String.format("Customer(%s, cart=%s, wishlist=%s)", super.toString(), this.cart, this.wishlist);
  }
}
