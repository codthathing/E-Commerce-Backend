package model;

import java.util.ArrayList;

public class ProductCatalog {
  private final ArrayList<Product> products;

  public ProductCatalog() {
    this.products = Product.products;
  }

  public void displayProducts() {
    this.products.forEach(product -> System.out.println(product.toString()));
  }

  public Product searchProduct(String productName) {
    return this.products.stream().filter(product -> product.getProductName().equals(productName)).findFirst().orElse(null);
  }

  public void updateProductPrice(String productName, Integer newProductPrice) {
    Product filterProduct = searchProduct(productName);
    if (filterProduct == null) {
      throw new IllegalArgumentException("Product not found: " + productName);
    }
    filterProduct.updateProductPrice(newProductPrice);
  }

  public void updateProductStock(String productName, Integer newStockCount) {
    Product filterProduct = searchProduct(productName);
    if (filterProduct == null) {
      throw new IllegalArgumentException("Product not found: " + productName);
    }
    filterProduct.updateProductStock(newStockCount);
  }

  public Product createProduct(String productName, String productDescription, Integer productPrice, Integer productStock) {
    return new Product(productName, productDescription, productPrice, productStock);
  }

  public void deleteProduct(String productName) {
    Product filterProduct = searchProduct(productName);
    if (filterProduct == null) {
      throw new IllegalArgumentException("Product not found: " + productName);
    }
    this.products.remove(filterProduct);
  }

  @Override
  public String toString() {
    return String.format("ProductCatalog(products=%s)", this.products);
  }
}