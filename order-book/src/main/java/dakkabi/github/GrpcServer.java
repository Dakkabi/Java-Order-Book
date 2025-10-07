package dakkabi.github;

import dakkabi.github.service.OrderBookService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * Entry-point for the Server application.
 */
public class GrpcServer {
  /**
   * Main runtime entry-point.
   *
   * @param args Optional arguments supplied to the program.
   */
  public static void main(String[] args) {
    Server server = ServerBuilder.forPort(0).addService(new OrderBookService()).build();
  }
}
