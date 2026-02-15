package model;
import java.util.ArrayList;

public class Product {
  static ArrayList<Product> products = new ArrayList<>();

  private final int id;
  private String productName;
  private String productDescription;
  private double productPrice;
  private int productStock;

  public Product(String productName, String productDescription, double productPrice, int productStock) {
    if (productPrice < 0) throw new IllegalArgumentException("Price can't be negative!");

    this.id = (int) (Math.random() * 1000);
    this.productName = productName;
    this.productDescription = productDescription;
    this.productPrice = productPrice;
    this.productStock = productStock;

    products.add(this);
  }

  public int getId() {
    return this.id;
  }

  @Override
  public String toString() {
    return String.format("Product(name=%s, description=%s, price=%.2f, stock=%d)", this.productName, this.productDescription, this.productPrice, this.productStock);
  }
}