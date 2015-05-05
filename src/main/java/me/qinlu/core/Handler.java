package me.qinlu.core;

import me.qinlu.thrift.MultiplicationService;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by qinlu on 15/5/4.
 */
public class Handler implements MultiplicationService.Iface {

  private static final Logger LOG = LoggerFactory.getLogger(Handler.class);

  @Override
  public int multiply(int n1, int n2) throws TException {
    LOG.info("Multiply(" + n1 + "," + n2 + ")");
    return n1 * n2;
  }

  @Override
  public void zip() throws TException {

  }
}
