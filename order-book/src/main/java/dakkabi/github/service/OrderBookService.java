package dakkabi.github.service;

import dakkabi.github.models.Side;
import dakkabi.github.proto.CreateOrderRequest;
import dakkabi.github.proto.CreateOrderResponse;
import dakkabi.github.proto.OrderBookServiceGrpc.OrderBookServiceImplBase;
import io.grpc.stub.StreamObserver;

/**
 * Business logic class for OrderBook, including gRPC services.
 */
public class OrderBookService extends OrderBookServiceImplBase {
  @Override
  public void createOrder(
      CreateOrderRequest request,
      StreamObserver<CreateOrderResponse> responseObserver
  ) {
    Side orderSide = SideMapper.getDomainSide(request.getSide());

    CreateOrderResponse response = CreateOrderResponse.newBuilder().setId(1).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
