package model;

public class Customer extends User {
  public Customer(String username, String email, String password) {
    super(username, email, password, TagEnum.MODERATOR);
  }

  @Override
  public String toString() {
    return String.format("Customer(%s)", super.toString());
  }
}
