package example.protobuf.proc;

import example.protobuf.idl.HelloworldRpc;
import io.grpc.ServerImpl;
import io.grpc.transport.netty.NettyServerBuilder;

import java.util.logging.Logger;

public class Server {
  private static final Logger logger = Logger.getLogger(Server.class.getName());

  private int port = 8003;
  private ServerImpl server;

  public static void main(String[] args) throws Exception {
    final Server server = new Server();
    server.start();
  }

  private void start() throws Exception {
    server = NettyServerBuilder.forPort(port)
      .addService(HelloworldRpc.bindService(new Handler()))
      .build().start();
    logger.info("Server started, listening on " + port);
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        System.err.println("*** shutting down gRPC server since JVM is shutting down");
        Server.this.stop();
        System.err.println("*** server shut down");
      }
    });
  }

  private void stop() {
    if (server != null) {
      server.shutdown();
    }
  }

}
