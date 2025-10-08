package dakkabi.github;

import dakkabi.github.proto.CreateOrderRequest;
import dakkabi.github.proto.CreateOrderResponse;
import dakkabi.github.proto.OrderBookServiceGrpc;
import dakkabi.github.proto.Side;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
  public static void main(String[] args) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
        .usePlaintext()
        .build();

    OrderBookServiceGrpc.OrderBookServiceBlockingStub stub
        = OrderBookServiceGrpc.newBlockingStub(channel);

    CreateOrderRequest createOrderRequest = CreateOrderRequest.newBuilder()
        .setSide(Side.ASK)
        .setPrice(50.54)
        .setQuantity(10)
        .build();

    CreateOrderResponse createOrderResponse = stub.createOrder(createOrderRequest);

    System.out.println(createOrderResponse.getId());

    channel.shutdown();
  }
}
