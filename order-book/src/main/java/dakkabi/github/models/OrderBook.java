package dakkabi.github.models;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Class representation of an order book, holding Order instances with a heap structure.
 */
public class OrderBook {
  private final PriorityQueue<Order> bidOrders;
  private final PriorityQueue<Order> askOrders;

  OrderBook() {
    Comparator<Order> priceDecreasing = new Comparator<Order>() {
      @Override
      public int compare(Order order1, Order order2) {
        return Long.compare(order1.getPrice(), order2.getPrice());
      }
    };

    bidOrders = new PriorityQueue<>(priceDecreasing.reversed());
    askOrders = new PriorityQueue<>(priceDecreasing);
  }

  /**
   * Add an order to its respective order book side.
   *
   * @param order The Order instance.
   */
  public void addOrder(Order order) {
    if (order.getSide().equals(SideEnum.ASK)) {
      askOrders.add(order);
    } else if (order.getSide().equals(SideEnum.BID)) {
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
