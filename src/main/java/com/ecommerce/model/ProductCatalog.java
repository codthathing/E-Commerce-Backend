package model;

import java.util.ArrayList;

public class ProductCatalog {
  public static ArrayList<Product> products;

  public void displayProducts() {
    products.forEach(product -> System.out.println(product.toString()));
  }

  public static Product searchProduct(String productName) {
    return products.stream().filter(product -> product.getProductName().equals(productName)).findFirst().orElse(null);
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
    Product newProduct = new Product(productName, productDescription, productPrice, productStock);
    products.add(newProduct);

    return newProduct;
  }

  public void deleteProduct(String productName) {
    Product filterProduct = searchProduct(productName);
    if (filterProduct == null) {
      throw new IllegalArgumentException("Product not found: " + productName);
    }
    products.remove(filterProduct);
  }

  @Override
  public String toString() {
    return String.format("ProductCatalog(products=%s)", products);
  }
}