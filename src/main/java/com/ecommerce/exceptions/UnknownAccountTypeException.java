package exceptions;

public class UnknownAccountTypeException extends RuntimeException {
  public UnknownAccountTypeException(String message) {
    super(message);
  }
}
