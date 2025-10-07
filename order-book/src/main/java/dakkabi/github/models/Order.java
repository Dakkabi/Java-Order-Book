package dakkabi.github.models;

/**
 * An immutable class representing a buyer's or seller's intention to buy or sell the asset.
 */
public class Order {
  private Long id;
  private final Side side;
  private final double price;
  private final long quantity;

  /**
   * Constructor for the Order class, excluding id attribute as that should be managed by the Order Book.
   *
   * @param side Whether the client intends to Buy or Sell.
   * @param price The price amount they are willing to Buy or Sell.
   * @param quantity The quantity they are willing to Buy or Sell.
   */
  public Order(Side side, double price, long quantity) {
    this.side = side;

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

  public double getPrice() {
    return price;
  }

  public long getQuantity() {
    return quantity;
  }
}
