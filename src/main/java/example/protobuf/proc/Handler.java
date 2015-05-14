package example.protobuf.proc;

import example.protobuf.idl.HelloWorldProto;
import example.protobuf.idl.HelloworldRpc;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by qinlu on 15/5/12.
 */
public class Handler implements HelloworldRpc.Greeter {

  private static final Logger LOG = LoggerFactory.getLogger(Handler.class);

  @Override
  public void sayHello(HelloWorldProto.HelloRequest req, StreamObserver<HelloWorldProto.HelloResponse> responseObserver) {
    LOG.info(req.toString());
    HelloWorldProto.HelloResponse reply = HelloWorldProto.HelloResponse.newBuilder().setMessage("Hello " + req.getName()).build();
    responseObserver.onValue(reply);
    responseObserver.onCompleted();
  }
}