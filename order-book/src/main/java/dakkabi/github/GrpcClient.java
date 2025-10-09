package dakkabi.github;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import dakkabi.github.proto.OrderBookServiceGrpc;
import dakkabi.github.proto.StartConnectionRequest;
import dakkabi.github.proto.StartConnectionResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.io.IOException;

/**
 * A client class to communicate with the gRPC server class.
 */
public class GrpcClient {

  private static void drawBorders(Screen screen) throws IOException {
    TerminalSize terminalSize = screen.getTerminalSize();

    TextGraphics text = screen.newTextGraphics();

    int columns = terminalSize.getColumns();
    int rows = terminalSize.getRows();

    for (int col = 0; col < columns / 2; col++) {
      text.putString(col, rows / 2,  "-");
    }

    for (int row = 0; row < rows; row++) {
      text.putString(columns / 2, row, "|");
    }
  }

  private static void drawTitles(Screen screen) throws IOException {
    TerminalSize terminalSize = screen.getTerminalSize();

    TextGraphics text = screen.newTextGraphics();

    int columns = terminalSize.getColumns();
    int rows = terminalSize.getRows();

    String yourOrders = "Your Orders";
    text.putString((columns / 4) - (yourOrders.length() / 2), rows / 2 + 1, yourOrders);

    String newOrder = "New Order";
    text.putString((columns / 4) - (newOrder.length() / 2), 0, newOrder);

    String orderBook = "Order Book";
    text.putString((3 * columns / 4) - (orderBook.length() / 2), 0, orderBook);
  }

  private static void draw(Screen screen) throws IOException {
    drawBorders(screen);
    drawTitles(screen);
    screen.refresh();
  }

  /**
   * Main process for the gRPC client.
   *
   * @param args Optional additional parameters, does nothing.
   */
  public static void main(String[] args) throws IOException {
    Screen screen = new DefaultTerminalFactory().createScreen();
    screen.startScreen();

    ManagedChannel channel = ManagedChannelBuilder
        .forAddress("localhost", 8080)
        .usePlaintext()
        .build();

    OrderBookServiceGrpc.OrderBookServiceBlockingStub stub
        = OrderBookServiceGrpc.newBlockingStub(channel);

    StartConnectionRequest startConnectionRequest = StartConnectionRequest.newBuilder()
        .build();

    while (true) {
      if (screen.doResizeIfNecessary() != null) {
        screen.clear();
        draw(screen);
      }
    }
  }
}
