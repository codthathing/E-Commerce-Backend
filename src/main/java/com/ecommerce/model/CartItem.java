package model;

import java.util.UUID;

public class CartItem {
  private final UUID id;
  private final Product product;
  private int quantity;

  public CartItem(UUID productID, String productName, double productPrice, int productQty) {
    this.id = UUID.randomUUID();
    this.product = new Product(productID, productName, productPrice);
    this.quantity = productQty;
  }

  public void setCartItemQuantity(int quantity) { this.quantity = quantity; }
  public double getCartItemSubTotal() { return this.quantity * this.product.getProductPrice(); }

  @Override
  public String toString() {
    return String.format("CartItem(id=%s, product_id=%s, name=%s, price=%.2f, quantity=%d)", this.id, this.product.getId(), this.product.getProductName(), this.product.getProductPrice(), this.quantity);
  }
}
