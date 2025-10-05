package dakkabi.github.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderBookTest {

  @Test
  public void getBestBidAndAskTest() {
    OrderBook orderBook = new OrderBook();

    Order askOrder = new Order(SideEnum.ASK, 100, 10);
    Order worseAskOrder = new Order(SideEnum.ASK, 500, 10);

    Order bidOrder = new Order(SideEnum.BID, 100, 10);
    Order worseBidOrder = new Order(SideEnum.BID, 50, 10);

    orderBook.addOrder(askOrder);
    orderBook.addOrder(worseAskOrder);
    orderBook.addOrder(bidOrder);
    orderBook.addOrder(worseBidOrder);

    assertEquals(100, orderBook.getBestAsk().getPrice());
    assertEquals(100, orderBook.getBestBid().getPrice());
  }
}
