package exceptions;

public class NotCustomer extends RuntimeException {
  public NotCustomer(String message) {
    super(message);
  }
}
