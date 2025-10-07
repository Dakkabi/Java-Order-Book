package dakkabi.github;

import dakkabi.github.models.Order;
import dakkabi.github.models.OrderBook;
import dakkabi.github.service.OrderBookService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

/**
 * Entry-point for the Server application.
 */
public class GrpcServer {
  /**
   * Main runtime entry-point.
   *
   * @param args Optional arguments supplied to the program.
   */
  public static void main(String[] args) throws IOException, InterruptedException {
    Server server = ServerBuilder.forPort(8080).addService(new OrderBookService()).build();

    server.start();
    server.awaitTermination();
  }
}
