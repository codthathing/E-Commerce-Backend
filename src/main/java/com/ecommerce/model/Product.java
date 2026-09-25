package model;
import exceptions.IllegalValue;

import java.util.UUID;

public class Product {
  private final UUID id;
  private final String productName;
  private final String productDescription;
  double productPrice;
  int productStock;

  public Product(UUID productID, String productName, double productPrice) {
    this(productID, productName, "", productPrice, 0);
  }

  public Product(String productName, String productDescription, double productPrice, int productStock) {
    if (productPrice < 1) throw new IllegalValue("Price can't be less than 1 Naira!");
    if (productStock < 1) throw new IllegalValue("Stock amount can't be less than 1!");

    this(UUID.randomUUID(), productName, productDescription, productPrice, productStock);
  }

  private Product(UUID id, String productName, String productDescription, double productPrice, int productStock) {
    this.id = id;
    this.productName = productName;
    this.productDescription = productDescription;
    this.productPrice = productPrice;
    this.productStock = productStock;
  }

  public UUID getId() { return id; }
  public String getProductName() {
    return productName;
  }
  public double getProductPrice() { return productPrice; }
  public int getProductStock() { return productStock; }

  public void updateProductPrice(double productPrice) {
    this.productPrice = productPrice;
  }

  public void updateProductStock(int productStock) {
    this.productStock = productStock;
  }

  @Override
  public String toString() {
    return String.format("Product(id=%s, name=%s, description=%s, price=%.2f, stock=%d)", this.id, this.productName, this.productDescription, this.productPrice, this.productStock);
  }
}