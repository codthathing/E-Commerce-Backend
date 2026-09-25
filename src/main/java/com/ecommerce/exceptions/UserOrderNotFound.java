package exceptions;

public class UserOrderNotFound extends RuntimeException {
  public UserOrderNotFound(String message) {
    super(message);
  }
}
