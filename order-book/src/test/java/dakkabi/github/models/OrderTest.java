package dakkabi.github.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {
  Order order;

  @BeforeEach
  public void beforeEach() {
    order = new Order(Side.ASK, Type.LIMIT,100.56d, 10);
  }

  @Test
  public void gettersAndSettersTest() {
    order.setId(100);

    assertEquals(100, order.getId());
    assertEquals(Side.ASK, order.getSide());
    assertEquals(100.56d, order.getPrice());
    assertEquals(10L, order.getQuantity());
    assertEquals(Type.LIMIT, order.getType());
  }

  @Test
  public void illegalArgumentExceptionTest() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> new Order(Side.ASK, Type.LIMIT,100.56d, -100));
  }
}
