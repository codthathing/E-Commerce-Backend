import model.Product;
import model.Tag;
import model.User;

public class Main {
  static void main(String[] args) {
    Product airForceOne = new Product("Air Force One", "This is a sneakers for casual outings", 1200, 5);
    User adminAdeboye = new User("@adeboye", "adeboye.kunle@gmail.com", Tag.ADMIN);
    User userFolabi = new User("@fola.creator", "fola.creator@gmail.com");

    System.out.println(airForceOne);
    System.out.println(adminAdeboye);
    System.out.println(userFolabi);
  }
}