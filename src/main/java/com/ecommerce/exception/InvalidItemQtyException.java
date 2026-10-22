package exception;

public class InvalidItemQtyException extends RuntimeException {
  public InvalidItemQtyException(String message) {
    super(message);
  }
}
