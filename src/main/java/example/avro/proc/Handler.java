package example.avro.proc;

import example.avro.idl.Mail;
import example.avro.idl.Message;
import org.apache.avro.AvroRemoteException;

/**
 * Created by qinlu on 15/5/12.
 */
public class Handler implements Mail {

  @Override
  public CharSequence send(Message message) throws AvroRemoteException {
    return message.getBody() == null ? "" : message.getBody();
  }
}
