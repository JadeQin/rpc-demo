package example.avro.proc;

import example.avro.idl.Mail;
import org.apache.avro.ipc.NettyServer;
import org.apache.avro.ipc.specific.SpecificResponder;

import java.net.InetSocketAddress;

/**
 * Created by qinlu on 15/5/12.
 */
public class Server {

  public static void main(String[] args) {
    org.apache.avro.ipc.Server server =
      new NettyServer(new SpecificResponder(Mail.class, new Handler()),
        new InetSocketAddress(9001));
    server.start();
  }
}
