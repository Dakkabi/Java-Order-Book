package dakkabi.github.models;

/**
 * An immutable class representing a buyer's or seller's intention to buy or sell the asset.
 */
public class Order {
  private Long id;
  private final Type type;
  private final Side side;
  private final double price;
  private final long quantity;

  /**
   * Constructor for the Order class, excluding id attribute as that should be
   * managed by the Order Book.
   *
   * @param side Whether the client intends to Buy or Sell.
   * @param type The order type specifying how the order should be executed.
   * @param price The price amount they are willing to Buy or Sell.
   * @param quantity The quantity they are willing to Buy or Sell.
   */
  public Order(Side side, Type type, double price, long quantity) {
    this.side = side;
    this.type = type;

    if (quantity < 0) {
      throw new IllegalArgumentException("Quantity cannot be negative");
    }

    this.price = price;
    this.quantity = quantity;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Side getSide() {
    return side;
  }

  public Type getType() {
    return type;
  }

  public double getPrice() {
    return price;
  }

  public long getQuantity() {
    return quantity;
  }
}
