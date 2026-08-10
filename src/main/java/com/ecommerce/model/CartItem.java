package model;

public class CartItem {
  private final Product product;
  private final int quantity;

  public CartItem(String productName, String productDescription, double productPrice, int productQty) {
    this.product = new Product(productName, productDescription, productPrice);
    this.quantity = productQty;
  }

  public int getCartItemQuantity() {
    return this.quantity;
  }

  @Override
  public String toString() {
    return String.format("CartItem(name=%s, description=%s, price=%.2f, quantity=%d)", this.product.getProductName(), this.product.getProductDescription(), this.product.getProductPrice(), this.getCartItemQuantity());
  }
}
