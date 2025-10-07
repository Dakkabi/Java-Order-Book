package dakkabi.github.models;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Class representation of an order book, holding Order instances with a heap structure.
 */
public class OrderBook {
  private final AtomicLong nextOrderId = new AtomicLong(0);
  private final PriorityQueue<Order> bidOrders;
  private final PriorityQueue<Order> askOrders;

  /**
   * Public constructor for OrderBook class.
   */
  public OrderBook() {
    Comparator<Order> priceDecreasing = Comparator.comparingDouble(Order::getPrice);

    bidOrders = new PriorityQueue<>(priceDecreasing.reversed());
    askOrders = new PriorityQueue<>(priceDecreasing);
  }

  /**
   * Add an order to its respective order book side.
   *
   * @param order The Order instance.
   */
  public void addOrder(Order order) {
    order.setId(nextOrderId.getAndIncrement());

    if (order.getSide().equals(Side.ASK)) {
      askOrders.add(order);
    } else if (order.getSide().equals(Side.BID)) {
      bidOrders.add(order);
    } else {
      throw new IllegalArgumentException("Unknown side " + order.getSide());
    }
  }
  
  public Order getBestBid() {
    return bidOrders.peek();
  }

  public Order getBestAsk() {
    return askOrders.peek();
  }
}
