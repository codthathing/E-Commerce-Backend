import model.Admin;
import model.Product;

public class Main {
  public static void main(String[] args) {
    Product airForceOne = new Product("Air Force One", "This is a sneakers for caual outings", 1200, 5);
    Admin adeboye = new Admin("@adeboye", "adeboye.kunle@gmail.com");

    System.out.println(airForceOne);
    System.out.println(adeboye);
  }
}