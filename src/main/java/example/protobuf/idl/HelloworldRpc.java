package example.protobuf.idl;


import static io.grpc.stub.Calls.*;
import static io.grpc.stub.ServerCalls.asyncUnaryRequestCall;
import static io.grpc.stub.ServerCalls.createMethodDefinition;

@javax.annotation.Generated("by gRPC proto compiler")
public class HelloworldRpc {

  private static final io.grpc.stub.Method<example.protobuf.idl.HelloWorldProto.HelloRequest,
    example.protobuf.idl.HelloWorldProto.HelloResponse> METHOD_SAY_HELLO =
    io.grpc.stub.Method.create(
      io.grpc.MethodType.UNARY, "SayHello",
      io.grpc.protobuf.ProtoUtils.marshaller(example.protobuf.idl.HelloWorldProto.HelloRequest.PARSER),
      io.grpc.protobuf.ProtoUtils.marshaller(example.protobuf.idl.HelloWorldProto.HelloResponse.PARSER));

  public static GreeterStub newStub(io.grpc.Channel channel) {
    return new GreeterStub(channel, CONFIG);
  }

  public static GreeterBlockingStub newBlockingStub(
    io.grpc.Channel channel) {
    return new GreeterBlockingStub(channel, CONFIG);
  }

  public static GreeterFutureStub newFutureStub(
    io.grpc.Channel channel) {
    return new GreeterFutureStub(channel, CONFIG);
  }

  public static final GreeterServiceDescriptor CONFIG =
    new GreeterServiceDescriptor();

  @javax.annotation.concurrent.Immutable
  public static class GreeterServiceDescriptor extends
    io.grpc.stub.AbstractServiceDescriptor<GreeterServiceDescriptor> {
    public final io.grpc.MethodDescriptor<example.protobuf.idl.HelloWorldProto.HelloRequest,
      example.protobuf.idl.HelloWorldProto.HelloResponse> sayHello;

    private GreeterServiceDescriptor() {
      sayHello = createMethodDescriptor(
        "helloworld.Greeter", METHOD_SAY_HELLO);
    }

    @SuppressWarnings("unchecked")
    private GreeterServiceDescriptor(
      java.util.Map<java.lang.String, io.grpc.MethodDescriptor<?, ?>> methodMap) {
      sayHello = (io.grpc.MethodDescriptor<example.protobuf.idl.HelloWorldProto.HelloRequest,
        example.protobuf.idl.HelloWorldProto.HelloResponse>) methodMap.get(
        CONFIG.sayHello.getName());
    }

    @java.lang.Override
    protected GreeterServiceDescriptor build(
      java.util.Map<java.lang.String, io.grpc.MethodDescriptor<?, ?>> methodMap) {
      return new GreeterServiceDescriptor(methodMap);
    }

    @java.lang.Override
    public com.google.common.collect.ImmutableList<io.grpc.MethodDescriptor<?, ?>> methods() {
      return com.google.common.collect.ImmutableList.<io.grpc.MethodDescriptor<?, ?>>of(
        sayHello);
    }
  }

  public static interface Greeter {

    public void sayHello(example.protobuf.idl.HelloWorldProto.HelloRequest request,
                         io.grpc.stub.StreamObserver<example.protobuf.idl.HelloWorldProto.HelloResponse> responseObserver);
  }

  public static interface GreeterBlockingClient {

    public example.protobuf.idl.HelloWorldProto.HelloResponse sayHello(example.protobuf.idl.HelloWorldProto.HelloRequest request);
  }

  public static interface GreeterFutureClient {

    public com.google.common.util.concurrent.ListenableFuture<example.protobuf.idl.HelloWorldProto.HelloResponse> sayHello(
      example.protobuf.idl.HelloWorldProto.HelloRequest request);
  }

  public static class GreeterStub extends
    io.grpc.stub.AbstractStub<GreeterStub, GreeterServiceDescriptor>
    implements Greeter {
    private GreeterStub(io.grpc.Channel channel,
                        GreeterServiceDescriptor config) {
      super(channel, config);
    }

    @java.lang.Override
    protected GreeterStub build(io.grpc.Channel channel,
                                GreeterServiceDescriptor config) {
      return new GreeterStub(channel, config);
    }

    @java.lang.Override
    public void sayHello(example.protobuf.idl.HelloWorldProto.HelloRequest request,
                         io.grpc.stub.StreamObserver<example.protobuf.idl.HelloWorldProto.HelloResponse> responseObserver) {
      asyncUnaryCall(
        channel.newCall(config.sayHello), request, responseObserver);
    }
  }

  public static class GreeterBlockingStub extends
    io.grpc.stub.AbstractStub<GreeterBlockingStub, GreeterServiceDescriptor>
    implements GreeterBlockingClient {
    private GreeterBlockingStub(io.grpc.Channel channel,
                                GreeterServiceDescriptor config) {
      super(channel, config);
    }

    @java.lang.Override
    protected GreeterBlockingStub build(io.grpc.Channel channel,
                                        GreeterServiceDescriptor config) {
      return new GreeterBlockingStub(channel, config);
    }

    @java.lang.Override
    public example.protobuf.idl.HelloWorldProto.HelloResponse sayHello(example.protobuf.idl.HelloWorldProto.HelloRequest request) {
      return blockingUnaryCall(
        channel.newCall(config.sayHello), request);
    }
  }

  public static class GreeterFutureStub extends
    io.grpc.stub.AbstractStub<GreeterFutureStub, GreeterServiceDescriptor>
    implements GreeterFutureClient {
    private GreeterFutureStub(io.grpc.Channel channel,
                              GreeterServiceDescriptor config) {
      super(channel, config);
    }

    @java.lang.Override
    protected GreeterFutureStub build(io.grpc.Channel channel,
                                      GreeterServiceDescriptor config) {
      return new GreeterFutureStub(channel, config);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<example.protobuf.idl.HelloWorldProto.HelloResponse> sayHello(
      example.protobuf.idl.HelloWorldProto.HelloRequest request) {
      return unaryFutureCall(
        channel.newCall(config.sayHello), request);
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
    final Greeter serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder("helloworld.Greeter")
      .addMethod(createMethodDefinition(
        METHOD_SAY_HELLO,
        asyncUnaryRequestCall(
          new io.grpc.stub.ServerCalls.UnaryRequestMethod<
            example.protobuf.idl.HelloWorldProto.HelloRequest,
            example.protobuf.idl.HelloWorldProto.HelloResponse>() {
            @java.lang.Override
            public void invoke(
              example.protobuf.idl.HelloWorldProto.HelloRequest request,
              io.grpc.stub.StreamObserver<example.protobuf.idl.HelloWorldProto.HelloResponse> responseObserver) {
              serviceImpl.sayHello(request, responseObserver);
            }
          }))).build();
  }
}
