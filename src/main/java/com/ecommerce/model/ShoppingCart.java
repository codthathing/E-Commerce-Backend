package model;
import exception.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCart {
  public static HashMap<String, ArrayList<CartItem>> carts;

  public void addItemToCart(String customerId, Boolean canModerate, String productName, int quantity) {
    Product item = ProductCatalog.searchProduct(productName);

    if (item == null) {
      throw new ProductNotExistsException("Product not found!");
    }

    if (quantity < 1) {
      throw new InvalidItemQtyException("Cart item can't be less than 1");
    }

    if (item.getProductStock() < quantity) {
      throw new InsufficientStockException(String.format("Insufficient stock, %d item(s) left!", item.getProductStock()));
    }

    if (carts.containsKey(customerId) && canModerate) {
      ArrayList<CartItem> cartItems = carts.get(customerId);
      cartItems.add(new CartItem(item.getId(), item.getProductName(), item.getProductPrice(), quantity));
    } else if (!carts.containsKey(customerId) && canModerate)  {
      ArrayList<CartItem> cartItems = new ArrayList<>();
      cartItems.add(new CartItem(item.getId(), item.getProductName(), item.getProductPrice(), quantity));

      carts.put(customerId, cartItems);
    } else {
      throw new NotCustomerException("Not a customer account!");
    }
  }

  public void removeItemFromCart(String customerId, Boolean canModerate, int itemId) {
    if (carts.containsKey(customerId) && canModerate) {
      carts.get(customerId).remove(itemId);
    } else {
      if (!canModerate) {
        throw new NotCustomerException("Not a customer account, can't modify cart!");
      }

      if (!carts.containsKey(customerId)) {
        throw new UserCartNotFoundException("User cart does not exists!");
      }
    }
  }

  public void modifyItemQuantity(String customerId, Boolean canModerate, int itemId, int quantity) {
    if (carts.containsKey(customerId) && canModerate) {
      CartItem currentCartItem = carts.get(customerId).get(itemId);
      Product currentProduct = ProductCatalog.searchProduct(currentCartItem.getCartItemProduct().getProductName());

      if (currentProduct.getProductStock() < quantity) {
        throw new InsufficientStockException(String.format("Insufficient quantity, %d item(s) left in stock!", currentProduct.getProductStock()));
      }

      currentCartItem.setCartItemQuantity(quantity);
    } else {
      if (!canModerate) {
        throw new NotCustomerException("Not a customer account, can't modify cart!");
      }

      if (!carts.containsKey(customerId)) {
        throw new UserCartNotFoundException("User cart does not exists!");
      }
    }
  }

  public double getCartTotal(String customerId, Boolean canModerate) {
    if (carts.containsKey(customerId) && canModerate) {
      ArrayList<CartItem> cartItems = carts.get(customerId);

      return cartItems.stream().reduce(0.0, (sum, item) -> sum + item.getCartItemSubTotal(), Double::sum);
    } else {
      if (!canModerate) {
        throw new NotCustomerException("Not a customer account!");
      }

      if (!carts.containsKey(customerId)) {
        throw new UserCartNotFoundException("User cart does not exists!");
      }

      return 0;
    }
  }
}
