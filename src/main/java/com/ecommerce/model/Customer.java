package model;
import java.util.ArrayList;

public class Customer extends User {
  private ArrayList<CartItem> cart;

  Customer(String username, String email) {
    super(username, email);
  }

  @Override
  void updateUsername() {}

  @Override
  void updateEmail() {}

  public void addItemCart() {
    System.out.println(this.cart);
  }

  public void deleteItemCart() {}
}
