package exceptions;

public class NotCustomerException extends RuntimeException {
  public NotCustomerException(String message) {
    super(message);
  }
}
