package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.UUID;

public class Order {
  public static ArrayList<Order> orders = new ArrayList<>();

  private final UUID orderId;
  private final UUID customerId;
  private final ArrayList<CartItem> cartItems;
  private OrderStatusEnum orderStatus;
  private final String orderDate;

  public Order(UUID customerId, ArrayList<CartItem> cartItems) {
    this.orderId = UUID.randomUUID();
    this.customerId = customerId;
    this.cartItems = cartItems;
    this.orderStatus = OrderStatusEnum.PENDING;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime orderDate = LocalDateTime.now();

    this.orderDate = orderDate.format(dtf);

    orders.add(this);
  }

  public void updateOrderStatus(OrderStatusEnum orderStatus) {
    this.orderStatus = orderStatus;
  }

  public ArrayList<CartItem> getCartItems() {
    return this.cartItems;
  }

  @Override
  public String toString() {
    return String.format("Order(id=%s, customerId=%s, status=%s, orderDate=%s)", this.orderId, this.customerId, this.orderStatus, this.orderDate);
  }
}
