package exceptions;

public class ProductNotExists extends RuntimeException {
  public ProductNotExists(String message) {
    super(message);
  }
}
