package dakkabi.github.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {
  Order order;

  @BeforeEach
  public void beforeEach() {
    order = new Order(SideEnum.ASK, 100.56d, 10);
  }

  @Test
  public void gettersTest() {
    assertEquals(SideEnum.ASK, order.getSide());
    assertEquals(100.56d, order.getPrice());
    assertEquals(10L, order.getQuantity());
  }
}
