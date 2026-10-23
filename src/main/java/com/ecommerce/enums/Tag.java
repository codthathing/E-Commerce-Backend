package enums;
import java.util.EnumSet;
import java.util.Set;

public enum Tag {
  ADMIN(EnumSet.of(Permission.ACCOUNT_CREATE, Permission.ORDER_READ, Permission.ORDER_CLEAR, Permission.PRODUCT_READ, Permission.PRODUCT_WRITE, Permission.PRODUCT_UPDATE, Permission.PRODUCT_DELETE, Permission.STOCK_UPDATE, Permission.POST_WRITE, Permission.POST_PUBLISH)),
  CATALOG_MANAGER(EnumSet.of(Permission.PRODUCT_WRITE, Permission.STOCK_UPDATE, Permission.PRICE_UPDATE, Permission.PRODUCT_UPDATE, Permission.PRODUCT_DELETE)),
  CONTENT_EDITOR(EnumSet.of( Permission.POST_WRITE, Permission.POST_PUBLISH, Permission.POST_DELETE, Permission.POST_UPDATE)),
  FULFILLMENT_AGENT(EnumSet.of(Permission.ORDER_READ, Permission.ORDER_CLEAR)),
  CUSTOMER(EnumSet.of(Permission.PRODUCT_READ, Permission.CART_WRITE, Permission.CART_READ, Permission.CART_UPDATE, Permission.CART_DELETE, Permission.CART_CLEAR, Permission.ORDER_WRITE, Permission.ORDER_DELETE));

  private final Set<Permission> permissions;
  Tag(Set<Permission> permissions) { this.permissions = permissions; }

  public Set<Permission> permissions() { return permissions; }
}