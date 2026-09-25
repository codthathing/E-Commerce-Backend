package model;

import enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.UUID;

public class Order {
  private final UUID orderId;
  private final ArrayList<CartItem> cartItems;
  private OrderStatus orderStatus;
  private final String orderDate;

  public Order(ArrayList<CartItem> cartItems) {
    this.orderId = UUID.randomUUID();
    this.cartItems = cartItems;
    this.orderStatus = OrderStatus.PENDING;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime orderDate = LocalDateTime.now();

    this.orderDate = orderDate.format(dtf);
  }

  public void updateOrderStatus(OrderStatus orderStatus) {
    this.orderStatus = orderStatus;
  }

  @Override
  public String toString() {
    return String.format("Order(id=%s, status=%s, orderDate=%s, cartItems=%s)", this.orderId, this.orderStatus, this.orderDate, this.cartItems);
  }
}
