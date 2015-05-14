package example.protobuf.proc.simple;

import com.google.protobuf.*;

/**
 * Created by qinlu on 15/5/12.
 */
public class MyRpcChannel implements RpcChannel{

  @Override
  public void callMethod(Descriptors.MethodDescriptor methodDescriptor, RpcController rpcController, Message message, Message message1, RpcCallback<Message> rpcCallback) {

  }
}
