package exceptions;

public class IllegalValue extends RuntimeException {
  public IllegalValue(String message) {
    super(message);
  }
}
