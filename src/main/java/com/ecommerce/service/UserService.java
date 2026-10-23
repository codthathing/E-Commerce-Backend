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
      case CATALOG_MANAGER:
        displayCatalogManagerMenu(logoutCallback);
        break;
      case CONTENT_EDITOR:
        displayContentEditorMenu(logoutCallback);
        break;
      case FULFILLMENT_AGENT:
        displayFulfillmentAgentMenu(logoutCallback);
        break;
      case CUSTOMER:
        displayCustomerMenu(logoutCallback);
        break;
    }
  }


  private void displayAdminMenu(Runnable logoutCallback) {
    System.out.println("1. View products in stock\n2. View current orders\n3. Post latest content\n4. Create staff account\n5. Account settings\n6. Log out\n");
    int choice = Integer.parseInt(scanner.nextLine());

    displayAdminMenuOptions(choice, logoutCallback);
  }

  private void displayAdminMenuOptions(int choice, Runnable logoutCallback) {
    switch (choice) {
      case 1:
        System.out.println("\nEnter product name: ");
        break;
      case 6:
        logoutCallback.run();
        break;
      default:
        System.out.printf("\n%d not part of options available\n\n1. View products in stock\n2. View current orders\n3. Post latest content\n4. Create staff account\n5. Account settings\n6. Log out\n\n", choice);
        choice = Integer.parseInt(scanner.nextLine());

        displayAdminMenuOptions(choice, logoutCallback);
    }
  }


  private void displayCatalogManagerMenu(Runnable logoutCallback) {
    System.out.println("1. View all products in stock\n2. Add Product\n3. Edit a product\n4. Delete product\n5. Account settings\n6. Log out\n");
    int choice = Integer.parseInt(scanner.nextLine());

    displayCatalogManagerMenuOptions(choice, logoutCallback);
  }

  private void displayCatalogManagerMenuOptions(int choice, Runnable logoutCallback) {
    switch (choice) {
      case 1:
        System.out.println("\nEnter product name: ");
        break;
      case 6:
        logoutCallback.run();
        break;
      default:
        System.out.printf("\n%d not part of options available\n\n1. View all products in stock\n2. Add Product\n3. Edit a product\n4. Delete product\n5. Account settings\n6. Log out\n\n", choice);
        choice = Integer.parseInt(scanner.nextLine());

        displayCatalogManagerMenuOptions(choice, logoutCallback);
    }
  }


  private void displayContentEditorMenu(Runnable logoutCallback) {
    System.out.println("1. Create a new content\n2. Publish a content from draft\n3. Delete a post\n4. Update an existing post\n5. Account settings\n6. Logout\n");
    int choice = Integer.parseInt(scanner.nextLine());

    displayContentEditorMenuOptions(choice, logoutCallback);
  }

  private void displayContentEditorMenuOptions(int choice, Runnable logoutCallback) {
    switch (choice) {
      case 1:
        System.out.println("Post content: ");
        break;
      case 6:
        logoutCallback.run();
        break;
      default:
        System.out.printf("\n%d not part of the options available\n\n1. Create a new content\n2. Publish a content from draft\n3. Delete a post\n4. Update an existing post\n5. Account settings\n6. Logout\n\n", choice);
        choice = Integer.parseInt(scanner.nextLine());

        displayContentEditorMenuOptions(choice, logoutCallback);
    }
  }


  private void displayFulfillmentAgentMenu(Runnable logoutCallback) {
    System.out.println("1. View current orders\n2. Clear customer order (ID)\n3. Account settings\n4. Logout\n");
    int choice = Integer.parseInt(scanner.nextLine());

    displayFulfillmentAgentMenuOptions(choice, logoutCallback);
  }

  private void displayFulfillmentAgentMenuOptions(int choice, Runnable logoutCallback) {
    switch (choice) {
      case 1:
        System.out.println("Clear order: ");
        break;
      case 4:
        logoutCallback.run();
        break;
      default:
        System.out.printf("\n%d not part of the options available\n\n1. View current orders\n2. Clear customer order (ID)\n3. Account settings\n4. Logout\n\n", choice);
        choice = Integer.parseInt(scanner.nextLine());

        displayFulfillmentAgentMenuOptions(choice, logoutCallback);
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
      case 6:
        logoutCallback.run();
        break;
      default:
        System.out.printf("\n%d not part of options available\n\n1. View product list\n2. Add product to cart\n3. View cart items\n4. Place order from cart\n5. Account settings\n6. Log out\n\n", choice);
        choice = Integer.parseInt(scanner.nextLine());

        displayCustomerMenuOptions(choice, logoutCallback);
    }
  }
}
