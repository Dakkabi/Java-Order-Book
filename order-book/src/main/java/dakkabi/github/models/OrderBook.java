package dakkabi.github.models;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Class representation of an order book, holding Order instances with a heap structure.
 */
public class OrderBook {
  private PriorityQueue<Order> bidOrders;
  private PriorityQueue<Order> askOrders;

  OrderBook() {
    Comparator<Order> priceDecreasing = new Comparator<Order>() {
      @Override
      public int compare(Order order1, Order order2) {
        return Long.compare(order1.getPrice(), order2.getPrice());
      }
    };

    bidOrders = new PriorityQueue<>(priceDecreasing);
    askOrders = new PriorityQueue<>(priceDecreasing.reversed());
  }

  public Queue<Order> getBidOrders() {
    return bidOrders;
  }

  public Queue<Order> getAskOrders() {
    return askOrders;
  }
}
