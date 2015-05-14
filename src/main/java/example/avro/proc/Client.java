package example.avro.proc;

import example.avro.idl.Mail;
import example.avro.idl.Message;
import org.apache.avro.ipc.NettyTransceiver;
import org.apache.avro.ipc.specific.SpecificRequestor;

import java.net.InetSocketAddress;

/**
 * Created by qinlu on 15/5/12.
 */
public class Client {

  public static void main(String[] args) throws Exception {
    NettyTransceiver client = new NettyTransceiver(new InetSocketAddress(9001));
    Mail mail = SpecificRequestor.getClient(Mail.class, client);

    Message msg = new Message("to", "from", "body");
    mail.send(msg);

    client.close();
  }
}
