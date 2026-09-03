package model;
import java.util.HashMap;
import java.util.Scanner;

class UserAlreadyExistsException extends Exception {
  public UserAlreadyExistsException(String message) {
    super(message);
  }
}

class UserNotFoundException extends Exception {
  public UserNotFoundException(String message) {
    super(message);
  }
}

class WrongPasswordException extends Exception {
  public WrongPasswordException(String message) {
    super(message);
  }
}

public class UserManager {
  private final HashMap<String, User> users = new HashMap<>();
  Scanner scanner = new Scanner(System.in);

  public User handleSignUpException(String choice) {
    if (choice.equalsIgnoreCase("y")) {
      return createUser();
    } else if (choice.equalsIgnoreCase("n")) {
      System.exit(0);
    } else {
      System.out.printf("%s not part of options!\n\nDo you want to create with another username (Y/N)? ", choice);
      choice = scanner.nextLine();

      return handleSignUpException(choice);
    }

    return null;
  }

  public User createUser() {
    HashMap<String, String> signUpCredentials = new HashMap<>();
    signUpCredentials.put("username", "");
    signUpCredentials.put("email", "");
    signUpCredentials.put("password", "");
    signUpCredentials.put("account type", "");

    for (String key : signUpCredentials.keySet()) {
      System.out.printf("Enter %s: ", key);
      String input = scanner.nextLine();
      signUpCredentials.replace(key, input);
    }

    User user = null;

    try {
      if (users.containsKey(signUpCredentials.get("username"))) throw new UserAlreadyExistsException("Username already exists!");

      if (signUpCredentials.get("account type").equals("admin")) {
        user = new Admin(signUpCredentials.get("username"), signUpCredentials.get("email"), signUpCredentials.get("password"));
      } else if (signUpCredentials.get("account type").equals("customer")) {
        user = new Customer(signUpCredentials.get("username"), signUpCredentials.get("email"), signUpCredentials.get("password"));
      }

      users.put(signUpCredentials.get("username"), user);
    } catch (UserAlreadyExistsException e) {
      System.out.println(e.getMessage());

      System.out.println("Do you want to create with another username (Y/N)? ");
      String choice = scanner.nextLine();

      return handleSignUpException(choice);
    }

    return user;
  }

  public User handleLoginException(String choice) {
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
    HashMap<String, String> loginCredentials = new HashMap<>();
    loginCredentials.put("username", "");
    loginCredentials.put("password", "");

    try {
      if (!users.containsKey(loginCredentials.get("username"))) throw new UserNotFoundException("User does not exist");

      User user = users.get(loginCredentials.get("username"));

      if (!user.getPassword().equals(loginCredentials.get("password"))) throw new WrongPasswordException("You entered the wrong password!");

      return user;
    } catch (UserNotFoundException e) {
      System.out.println(e.getMessage());

      System.out.println("Do you want to create with another username (Y/N)? ");
      String choice = scanner.nextLine();

      return handleSignUpException(choice);
    } catch (WrongPasswordException e) {
      System.out.println(e.getMessage());

      System.out.println("Do you want to try again (Y/N)? ");
      String choice = scanner.nextLine();

      return handleLoginException(choice);
    }
  }
}
