package dakkabi.github;


import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

/**
 * A client class to communicate with the gRPC server class.
 */
public class GrpcClient {
  /**
   * Main process for the gRPC client.
   *
   * @param args Optional additional parameters, does nothing.
   */
  public static void main(String[] args) throws IOException, InterruptedException {
    Terminal terminal = new DefaultTerminalFactory().createTerminal();

  }
}
