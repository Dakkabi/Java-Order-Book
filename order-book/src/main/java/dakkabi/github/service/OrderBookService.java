package dakkabi.github.service;

import dakkabi.github.models.Order;
import dakkabi.github.models.OrderBook;
import dakkabi.github.models.Side;
import dakkabi.github.models.Type;
import dakkabi.github.proto.CreateOrderRequest;
import dakkabi.github.proto.CreateOrderResponse;
import dakkabi.github.proto.OrderBookServiceGrpc.OrderBookServiceImplBase;
import io.grpc.stub.StreamObserver;

/**
 * Business logic class for OrderBook, including gRPC services.
 */
public class OrderBookService extends OrderBookServiceImplBase {
  private final OrderBook orderBook;

  /**
   * Public constructor for OrderBookService, with an OrderBook parameter.
   *
   * @param orderBook The order book to manage.
   */
  public OrderBookService(OrderBook orderBook) {
    this.orderBook = orderBook;
  }

  @Override
  public void createOrder(
      CreateOrderRequest request,
      StreamObserver<CreateOrderResponse> responseObserver
  ) {
    Side orderSide = ProtoAdapter.getDomainSide(request.getSide());
    Type orderType = ProtoAdapter.getDomainType(request.getType());
    Order newOrder = new Order(
        orderSide,
        orderType,
        request.getPrice(),
        request.getQuantity()
    );

    newOrder = orderBook.addOrder(newOrder);

    CreateOrderResponse response = CreateOrderResponse.newBuilder().setId(newOrder.getId()).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
