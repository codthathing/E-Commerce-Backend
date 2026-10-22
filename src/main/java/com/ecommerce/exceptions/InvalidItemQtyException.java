package exceptions;

public class InvalidItemQtyException extends RuntimeException {
  public InvalidItemQtyException(String message) {
    super(message);
  }
}
