package medtravBeans;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext; 

import com.sun.mail.handlers.message_rfc822;

import entities.User;
import services.impl.MessageManagerLocal;
import services.impl.Message;
import services.impl.MessageManager;
/**
 *
 *
 */
@ManagedBean
@ViewScoped
public class MessageBean  {
 
    @EJB
    MessageManagerLocal mm;
 
    private final List messages;
    private Date lastUpdate;
    private Message message;
    private int nombre=1;
    private String userCo="Ali";
   

    
    
	@ManagedProperty(value = "#{loginBean.found}")
	private User user;
    
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String goTestimony() {
		
		return "listTestimony";
	}
    
    public String getUserCo() {
		return userCo;
	}

	public void setUserCo(String userCo) {
		this.userCo = userCo;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	/**
     * Creates a new instance of MessageBean
     */
    public MessageBean() {
    //	System.out.println("1 ============ mon NOM EST ========"+user.getLogin());
        messages = Collections.synchronizedList(new LinkedList());
        lastUpdate = new Date(0);
        message = new Message();
   /*     if(user.getFirstName() != null && !user.getFirstName().isEmpty() ){
        	System.out.println("2 == mon NOM EST "+user.getLogin());
        	message.setUser(user.getLogin());}
        else{message.setUser("coco");}
   */  
        message.setUser("coco");
    }
    
  
 
    public Date getLastUpdate() {
        return lastUpdate;
    }
 
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
 
    public Message getMessage() {
    
        return message;
    }
 
    public void setMessage(Message message) {
        this.message = message;
    }
 
    public void sendMessage() {
        mm.sendMessage(message);
    }
    public void userLog(){
    	   if(user.getFirstName()!=null){message.setUser(user.getLogin());}
           else{message.setUser("cocoA");}
    }
 
    public void firstUnreadMessage(ActionEvent evt) {
       RequestContext ctx = RequestContext.getCurrentInstance();
 
       Message m = mm.getFirstAfter(lastUpdate);
       userLog();
 
       ctx.addCallbackParam("ok", m!=null);
       if(m==null)
           return;
 
       lastUpdate = m.getDateSent();
 
       ctx.addCallbackParam("user", m.getUser());
       ctx.addCallbackParam("dateSent", m.getDateSent().toString());
       ctx.addCallbackParam("text", m.getMessage());
 
    }

	public List getMessages() {
		return messages;
	}
 
}