package services.interfaces;

import javax.ejb.Remote;

@Remote
public interface GreetingsRemote {
	
	String tiSallem (String name);

}
