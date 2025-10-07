package dakkabi.github.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class OrderBookTest {

  @Test
  public void getBestBidAndAskTest() {
    OrderBook orderBook = new OrderBook();

    Order askOrder = new Order(Side.ASK, 100, 10);
    Order worseAskOrder = new Order(Side.ASK, 500, 10);

    Order bidOrder = new Order(Side.BID, 100, 10);
    Order worseBidOrder = new Order(Side.BID, 50, 10);

    orderBook.addOrder(askOrder);
    orderBook.addOrder(worseAskOrder);
    orderBook.addOrder(bidOrder);
    orderBook.addOrder(worseBidOrder);

    assertEquals(100, orderBook.getBestAsk().getPrice());
    assertEquals(100, orderBook.getBestBid().getPrice());

    assertEquals(0, orderBook.getBestAsk().getId());
    assertNotEquals(orderBook.getBestAsk().getId(), orderBook.getBestBid().getId());
  }
}
