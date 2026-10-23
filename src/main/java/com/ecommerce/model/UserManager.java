package model;
import enums.Tag;
import exception.UnknownAccountTypeException;
import exception.UserAlreadyExistsException;
import exception.UserNotFoundException;
import exception.WrongPasswordException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class UserManager {
  private static final HashMap<String, User> users = new HashMap<>();
  private final Scanner scanner;

  public UserManager(Scanner scanner) {
    this.scanner = scanner;
  }

  private User handleSignUpException(String choice) {
    if (choice.equalsIgnoreCase("y")) {
      return createUser();
    } else if (choice.equalsIgnoreCase("n")) {
      return authenticateUser();
    } else {
      System.out.printf("\n%s not part of options!\n\nDo you want to create with another username (Y/N)? ", choice);
      choice = scanner.nextLine();

      return handleSignUpException(choice);
    }
  }

  public  User createUser() {
    LinkedHashMap<String, String> signUpCredentials = new LinkedHashMap<>();

    signUpCredentials.put("username", "");
    signUpCredentials.put("email", "");
    signUpCredentials.put("password", "");
    signUpCredentials.put("accountType", "");

    LinkedHashMap<String, String> prompts = new LinkedHashMap<>();
    prompts.put("username", "Enter username: ");
    prompts.put("email", "Enter email: ");
    prompts.put("password", "Enter password: ");
    prompts.put("accountType", "Enter account type (admin/fulfillment_agent/catalog_manager/content_editor/customer): ");

    System.out.println();
    for (String key : signUpCredentials.keySet()) {
      System.out.print(prompts.get(key));
      signUpCredentials.put(key, scanner.nextLine());
    }

    User user;

    try {
      if (users.containsKey(signUpCredentials.get("username"))) throw new UserAlreadyExistsException("Username already exists!");

      if (signUpCredentials.get("accountType").equals("admin")) {
        user = new User(signUpCredentials.get("username"), signUpCredentials.get("email"), signUpCredentials.get("password"), Tag.ADMIN);
      } else if (signUpCredentials.get("accountType").equals("fulfillment_agent")) {
        user = new User(signUpCredentials.get("username"), signUpCredentials.get("email"), signUpCredentials.get("password"), Tag.FULFILLMENT_AGENT);
      } else if (signUpCredentials.get("accountType").equals("catalog_manager")) {
        user = new User(signUpCredentials.get("username"), signUpCredentials.get("email"), signUpCredentials.get("password"), Tag.CATALOG_MANAGER);
      } else if (signUpCredentials.get("accountType").equals("content_editor")) {
        user = new User(signUpCredentials.get("username"), signUpCredentials.get("email"), signUpCredentials.get("password"), Tag.CONTENT_EDITOR);
      } else if (signUpCredentials.get("accountType").equals("customer")) {
        user = new User(signUpCredentials.get("username"), signUpCredentials.get("email"), signUpCredentials.get("password"), Tag.CUSTOMER);
      } else {
        throw new UnknownAccountTypeException("Unknown account type!");
      }

      users.put(signUpCredentials.get("username"), user);
    } catch (UserAlreadyExistsException e) {
      return handleSignUpError(e, "\n\nDo you want to create with another username (Y/N)? ");
    } catch (UnknownAccountTypeException e) {
      return handleSignUpError(e, "\n\nDo you want to try again (Y/N)? ");
    }

    return user;
  }

  private User handleSignUpError(Exception e, String message) {
    System.out.printf("\n%s", e.getMessage());

    System.out.print(message);
    String choice = scanner.nextLine();

    return handleSignUpException(choice);
  }

  private User handleLoginException(String choice) {
    if (choice.equalsIgnoreCase("y")) {
      return loginUser();
    } else if (choice.equalsIgnoreCase("n")) {
      System.exit(0);
    } else  {
      System.out.printf("%s not part of options!\n Do you want to try again (Y/N)?", choice);
      choice = scanner.nextLine();
      return handleLoginException(choice);
    }

    return null;
  }

  public User loginUser() {
    LinkedHashMap<String, String> loginCredentials = new LinkedHashMap<>();

    loginCredentials.put("username", "");
    loginCredentials.put("password", "");

    LinkedHashMap<String, String> prompts = new LinkedHashMap<>();
    prompts.put("username", "Enter username: ");
    prompts.put("password", "Enter password: ");

    System.out.println();
    for (String key : loginCredentials.keySet()) {
      System.out.print(prompts.get(key));
      loginCredentials.put(key, scanner.nextLine());
    }

    try {
      if (!users.containsKey(loginCredentials.get("username"))) throw new UserNotFoundException("User does not exist");

      User user = users.get(loginCredentials.get("username"));

      if (!user.getPassword().equals(loginCredentials.get("password"))) throw new WrongPasswordException("You entered the wrong password!");

      return user;
    } catch (UserNotFoundException e) {
      return handleLoginError(e, "\n\nDo you want to create with another username (Y/N)? ");
    } catch (WrongPasswordException e) {
      return handleLoginError(e, "\n\nDo you want to try again (Y/N)? ");
    }
  }

  public User handleLoginError(Exception e, String message) {
    System.out.printf("\n%s", e.getMessage());

    System.out.print(message);
    String choice = scanner.nextLine();

    return handleLoginException(choice);
  }

  public User authenticateUser() {
    System.out.println("\nWelcome to Order Management System\n\n1. Log in\n2. Create an account\n3. Exit\n");
    int choice = Integer.parseInt(scanner.nextLine());

    return authenticateUserOptions(choice);
  }

  private User authenticateUserOptions(int choice) {
    switch (choice) {
      case 1:
        return loginUser();
      case 2:
        return createUser();
      case 3:
        exit();
        break;
      default:
        System.out.printf("\n%d not part of options available\n\n1. Log in\n2. Create an account\n3. Exit\n", choice);
        choice = Integer.parseInt(scanner.nextLine());

        authenticateUserOptions(choice);
    }

    return null;
  }

  private static void exit() {
    System.out.println("\nThanks for visiting Calor Stitches!");
    System.exit(0);
  }
}
