package service;
import model.User;

import java.util.Scanner;

public class UserService {
  private final Scanner scanner;

  public UserService(Scanner scanner) {
    this.scanner = scanner;
  }

  public void displayMenu(User user, Runnable logoutCallback) {
    System.out.printf("\nWelcome to Calor Stitches!\nThanks for shopping with us.\n\nUsername: %s\nEmail: %s\n\n", user.getUsername(), user.getEmail());

    switch (user.getTag()) {
      case ADMIN:
        displayAdminMenu(logoutCallback);
        break;
      case MODERATOR:
        displayModeratorMenu(logoutCallback);
        break;
      case CUSTOMER:
        displayCustomerMenu(logoutCallback);
        break;
    }
  }

  private void displayModeratorMenu(Runnable logoutCallback) {
    System.out.println("1. Add Product\n2. Edit a product\n3. View all products in stock\n4. Account settings\n5. Log out\n");
    int choice = Integer.parseInt(scanner.nextLine());

    displayModeratorMenuOptions(choice, logoutCallback);
  }

  private void displayModeratorMenuOptions(int choice, Runnable logoutCallback) {
    switch (choice) {
      case 1:
        System.out.println("\nEnter product name: ");
        break;
      case 2:
        System.out.println("\nEnter product price: ");
        break;
      case 3:
        System.out.println("\nEnter product quantity: ");
        break;
      case 4:
        System.out.println("\nEnter account username: ");
        break;
      case 5:
        logoutCallback.run();
        break;
      default:
        System.out.println("\n%d not part of options available\n\n1. Add Product\n2. Edit a product\n3. View all products in stock\n4. Account settings\n5. Log out\n");
        choice = Integer.parseInt(scanner.nextLine());

        displayModeratorMenuOptions(choice, logoutCallback);
    }
  }

  private void displayAdminMenu(Runnable logoutCallback) {
    System.out.println("1. Filter products in stock\n2. View orders\n3. Clear an order\n4. Account settings\n5. Log out\n");
    int choice = Integer.parseInt(scanner.nextLine());

    displayAdminMenuOptions(choice, logoutCallback);
  }

  private void displayAdminMenuOptions(int choice, Runnable logoutCallback) {
    switch (choice) {
      case 1:
        System.out.println("\nEnter product name: ");
        break;
      case 2:
        System.out.println("\nEnter customer name: ");
        break;
      case 3:
        System.out.println("\nEnter admin code: ");
        break;
      case 4:
        System.out.println("\nEnter account username: ");
        break;
      case 5:
        logoutCallback.run();
        break;
      default:
        System.out.println("\n%d not part of options available\n\n1. Filter products in stock\n2. View orders\n3. Clear an order\n4. Account settings\n5. Log out\n");
        choice = Integer.parseInt(scanner.nextLine());

        displayAdminMenuOptions(choice, logoutCallback);
    }
  }

  private void displayCustomerMenu(Runnable logoutCallback) {
    System.out.println("1. View product list\n2. Add product to cart\n3. View cart items\n4. Place order from cart\n5. Account settings\n6. Log out\n");
    int choice = Integer.parseInt(scanner.nextLine());

    displayCustomerMenuOptions(choice, logoutCallback);
  }

  private void displayCustomerMenuOptions(int choice, Runnable logoutCallback) {
    switch (choice) {
      case 1:
        System.out.println("\nEnter filter option: ");
        break;
      case 2:
        System.out.println("\nEnter product name: ");
        break;
      case 3:
        System.out.println("\nEnter cart item ID: ");
        break;
      case 4:
        System.out.println("\nPlace order from cart items: ");
        break;
      case 5:
        System.out.println("\nEnter account username: ");
        break;
      case 6:
        logoutCallback.run();
        break;
      default:
        System.out.println("\n%d not part of options available\n\n1. View product list\n2. Add product to cart\n3. View cart items\n4. Place order from cart\n5. Account settings\n6. Log out\n");
        choice = Integer.parseInt(scanner.nextLine());

        displayCustomerMenuOptions(choice, logoutCallback);
    }
  }
}
