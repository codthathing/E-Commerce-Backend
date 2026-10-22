package exceptions;

public class UserOrderNotFoundException extends RuntimeException {
  public UserOrderNotFoundException(String message) {
    super(message);
  }
}
