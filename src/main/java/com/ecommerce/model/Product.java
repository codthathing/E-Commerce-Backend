package model;
import java.util.ArrayList;

public class Product {
  private final int id;
  private final String productName;
  private final String productDescription;
  private final double productPrice;
  private final int productStock;

  public Product(String productName, String productDescription, double productPrice) {
    this(productName, productDescription, productPrice, 0);
  }

  public Product(String productName, String productDescription, double productPrice, int productStock) {
    if (productPrice < 0) throw new IllegalArgumentException("Price can't be negative!");

    this.id = (int) (Math.random() * 1000);
    this.productName = productName;
    this.productDescription = productDescription;
    this.productPrice = productPrice;
    this.productStock = productStock;
  }

  public int getId() {
    return id;
  }
  public String getProductName() {
    return productName;
  }
  public String getProductDescription() {
    return productDescription;
  }
  public double getProductPrice() {
    return productPrice;
  }

  @Override
  public String toString() {
    return String.format("Product(name=%s, description=%s, price=%.2f, stock=%d)", this.productName, this.productDescription, this.productPrice, this.productStock);
  }
}