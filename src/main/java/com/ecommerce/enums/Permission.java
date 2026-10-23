package enums;

public enum Permission {
  ORDER_READ("order:read"),
  ORDER_CLEAR("order:clear"),
  PRODUCT_WRITE("product:write"),
  PRODUCT_UPDATE("product:update"),
  PRODUCT_DELETE("product:delete"),
  STOCK_UPDATE("stock:update"),
  POST_WRITE("post:write"),
  POST_PUBLISH("post:publish"),
  POST_DELETE("post:delete"),
  POST_UPDATE("post:update"),
  PRODUCT_READ("product:read"),
  CART_WRITE("cart:write"),
  CART_READ("cart:read"),
  CART_UPDATE("cart:update"),
  CART_DELETE("cart:delete"),
  CART_CLEAR("cart:clear"),
  ORDER_WRITE("order:write"),
  ORDER_DELETE("order:delete"),
  PRICE_UPDATE("price:update"),
  ACCOUNT_CREATE("account:create");

  private final String value;
  Permission(String value) { this.value = value; }
  public String value() { return value; }
}
