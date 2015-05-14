package example.protobuf.proc;

import example.protobuf.idl.HelloWorldProto;
import example.protobuf.idl.HelloworldRpc;
import io.grpc.ChannelImpl;
import io.grpc.transport.netty.NegotiationType;
import io.grpc.transport.netty.NettyChannelBuilder;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
  private static final Logger logger = Logger.getLogger(Client.class.getName());

  private final ChannelImpl channel;
  private final HelloworldRpc.GreeterBlockingStub blockingStub;

  public static void main(String[] args) throws Exception {
    Client client = new Client("localhost", 8003);
    try {
      client.greet("Hello");
    } finally {
      client.shutdown();
    }
  }

  public Client(String host, int port) {
    channel = NettyChannelBuilder.forAddress(host, port).negotiationType(NegotiationType.PLAINTEXT)
      .build();
    blockingStub = HelloworldRpc.newBlockingStub(channel);
  }

  public void greet(String name) {
    try {
      logger.info("Will try to greet " + name + " ...");
      HelloWorldProto.HelloRequest request = HelloWorldProto.HelloRequest.newBuilder().setName(name).build();
      HelloWorldProto.HelloResponse response = blockingStub.sayHello(request);
      logger.info("Greeting: " + response.getMessage());
    } catch (RuntimeException e) {
      logger.log(Level.WARNING, "RPC failed", e);
      return;
    }
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTerminated(5, TimeUnit.SECONDS);
  }

}
