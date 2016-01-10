package services.impl;

import java.util.Date;
import javax.ejb.Local;
import services.impl.Message;

/**
* Local interface for chat lagic EJB
* @author Danon
*/
@Local
public interface MessageManagerLocal {

   void sendMessage(Message msg);

   Message getFirstAfter(Date after);

}