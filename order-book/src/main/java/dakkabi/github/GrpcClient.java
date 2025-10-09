package dakkabi.github;

import dakkabi.github.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

/**
 * A client class to communicate with the gRPC server class.
 */
public class GrpcClient {
  /**
   * Main process for the gRPC client.
   *
   * @param args Optional additional parameters, does nothing.
   */
  public static void main(String[] args) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
        .usePlaintext()
        .build();

    OrderBookServiceGrpc.OrderBookServiceBlockingStub stub
        = OrderBookServiceGrpc.newBlockingStub(channel);

    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("New Order? (Y/N)");
      if (scanner.nextLine().equals("N")) {
        break;
      }

      System.out.println("Enter Order side:");
      Side orderSide = Side.valueOf(scanner.nextLine().toUpperCase());

      System.out.println("Enter Order type:");
      OrderType orderType = OrderType.valueOf(scanner.nextLine().toUpperCase());

      System.out.println("Enter Order price:");
      double price = Long.parseLong(scanner.nextLine());

      System.out.println("Enter Order quantity:");
      long quantity = Long.parseLong(scanner.nextLine());

      CreateOrderRequest createOrderRequest = CreateOrderRequest.newBuilder()
          .setSide(orderSide)
          .setType(orderType)
          .setPrice(price)
          .setQuantity(quantity)
          .build();

      CreateOrderResponse createOrderResponse = stub.createOrder(createOrderRequest);

      System.out.println("Order created, Order ID:" + createOrderResponse.getId());
    }

    channel.shutdown();
  }
}
