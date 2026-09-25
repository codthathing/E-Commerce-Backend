package exceptions;

public class InvalidItemQty extends RuntimeException {
  public InvalidItemQty(String message) {
    super(message);
  }
}
