import model.*;
import service.UserService;
import service.UserService.*;

import java.util.Scanner;

public class Main {
  static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    UserManager userManager = new UserManager(scanner);
    ProductCatalog productManager = new ProductCatalog();
    ShoppingCart carts = new ShoppingCart();
    OrderManager orderManager = new OrderManager();

    UserService userService = new UserService(scanner);

    handleApplication(userManager, userService);

    scanner.close();
  }

  public static void handleApplication(UserManager userManager, UserService userService) {
    User user = userManager.authenticateUser();
    userService.displayMenu(user, () -> handleApplication(userManager, userService));
  }
}