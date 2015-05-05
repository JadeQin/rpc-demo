package me.qinlu.core;

import me.qinlu.thrift.MultiplicationService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by qinlu on 15/5/4.
 */
public class Client {

  private static final Logger LOG = LoggerFactory.getLogger(Client.class);

  public static void main(String[] args) throws Exception {

//    TTransport transport = new TFramedTransport(new TSocket("localhost", 1988));
//    transport.open();
//
//    TProtocol protocol = new TBinaryProtocol(transport);
//    final MultiplicationService.Client client = new MultiplicationService.Client(protocol);

    for (int i = 0; i < 5; i++) {
      new MultiThread( i).start();
    }

//    transport.close();

  }

  static class MultiThread extends Thread {

    private int num;
    private MultiplicationService.Client client;

    public MultiThread( int num) throws Exception{
      this.num = num;

      TTransport transport = new TFramedTransport(new TSocket("localhost", 1988));
      transport.open();
      TProtocol protocol = new TBinaryProtocol(transport);
      client = new MultiplicationService.Client(protocol);
    }

    @Override
    public void run() {
      int result = 0;
      try {
        result = client.multiply(num, num + 1);
      } catch (TException e) {
        LOG.info("TException", e);
      }
      LOG.info(result + "");
    }
  }
}

