import model.Admin;
import model.Customer;
import model.Product;

public class Main {
  static void main(String[] args) {
    Product airForceOne = new Product("Air Force One", "This is a sneakers for casual outings", 1200, 5);
    Admin adminAdeboye = new Admin("@adeboye", "adeboye.kunle@gmail.com");
    Customer userFolabi = new Customer("@fola.creator", "fola.creator@gmail.com");

    userFolabi.addItemToCart(airForceOne, 4);
    userFolabi.modifyItemQuantity(0, 2);

    System.out.println(airForceOne);
    System.out.println(adminAdeboye);
    System.out.println(userFolabi);
    System.out.printf("Cart Total: %f", userFolabi.getCartTotal());
  }
}