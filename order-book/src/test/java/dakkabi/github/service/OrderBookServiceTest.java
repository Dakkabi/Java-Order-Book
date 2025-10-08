package dakkabi.github.service;

import dakkabi.github.models.OrderBook;
import dakkabi.github.proto.CreateOrderRequest;
import dakkabi.github.proto.CreateOrderResponse;
import dakkabi.github.proto.OrderBookServiceGrpc;
import dakkabi.github.proto.Side;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderBookServiceTest {
  private Server server;
  private ManagedChannel channel;
  private OrderBookServiceGrpc.OrderBookServiceBlockingStub orderBookStub;

  @BeforeEach
  public void beforeEach() throws IOException {
    server = ServerBuilder.forPort(8080).addService(new OrderBookService(new OrderBook())).build();
    server.start();

    channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();
    orderBookStub = OrderBookServiceGrpc.newBlockingStub(channel);
  }

  @AfterEach
  public void afterEach() {
    channel.shutdownNow();
    server.shutdownNow();
  }

  @Test
  public void createOrderTest() {
    CreateOrderRequest request = CreateOrderRequest.newBuilder()
        .setSide(Side.ASK)
        .setPrice(100)
        .setQuantity(50)
        .build();

    CreateOrderResponse response = orderBookStub.createOrder(request);

    assertNotNull(response);
    assertEquals(0, response.getId());
  }
}
