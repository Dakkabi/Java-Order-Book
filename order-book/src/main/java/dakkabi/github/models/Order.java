package dakkabi.github.models;

/**
 * An immutable class representing a buyer's or seller's intention to buy or sell the asset.
 */
public class Order {
  private final SideEnum side;
  private final long price;
  private final long quantity;

  Order(SideEnum side, long price, long quantity) {
    this.side = side;

    if (quantity < 0) {
      throw new IllegalArgumentException("Quantity cannot be negative");
    }

    this.price = price;
    this.quantity = quantity;
  }

  public SideEnum getSide() {
    return side;
  }

  public long getPrice() {
    return price;
  }

  public long getQuantity() {
    return quantity;
  }
}
