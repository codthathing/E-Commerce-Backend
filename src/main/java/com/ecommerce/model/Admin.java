package model;

public class Admin extends User {
  private static int adminCount = 0;
  private String tag;

  public Admin(String username, String email){
    super(username, email);
    this.tag = String.format("Admin %d", ++adminCount);
  }

  @Override
  void updateUsername() {}

  @Override
  void updateEmail() {}

  public void addProduct() {}

  public void updateProduct() {}

  public void deleteProduct() {}

  @Override
  public String toString() {
    return String.format("Admin(%s, tag=%s)", super.toString(), this.tag);
  }
}
