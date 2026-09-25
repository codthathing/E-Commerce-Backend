package exceptions;

public class UserCartNotFound extends RuntimeException {
  public UserCartNotFound(String message) {
    super(message);
  }
}
