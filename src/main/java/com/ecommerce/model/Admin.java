package model;

public class Admin extends User {
  public Admin(String username, String email) {
    super(username, email, Tag.ADMIN);
  }

  @Override
  public String toString() {
    return String.format("Admin(%s)",  super.toString());
  }
}
