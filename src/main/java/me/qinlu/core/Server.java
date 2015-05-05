package me.qinlu.core;

import me.qinlu.thrift.MultiplicationService;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

/**
 * Created by qinlu on 15/5/4.
 */
public class Server {

  public static Handler handler;

  public static MultiplicationService.Processor processor;

  public static void main(String[] args) {
    try {
      handler = new Handler();
      processor = new MultiplicationService.Processor(handler);

      Runnable simple = new Runnable() {
        public void run() {
          simple(processor);
        }
      };

      new Thread(simple).start();
    } catch (Exception x) {
      x.printStackTrace();
    }
  }

  public static void simple(MultiplicationService.Processor processor) {
    try {
      TNonblockingServerSocket serverTransport = new TNonblockingServerSocket(1988);
      TServer server = new TNonblockingServer(new TNonblockingServer.Args(serverTransport).processor(processor));

      System.out.println("Starting the simple server...");
      server.serve();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
