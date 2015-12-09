package services.impl;

import javax.ejb.Stateless;

import services.interfaces.GreetingsRemote;

/**
 * Session Bean implementation class Greetings
 */
@Stateless
public class Greetings implements GreetingsRemote {

    /**
     * Default constructor. 
     */
    public Greetings() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String tiSallem(String name) {
		return "aslema "+name+" !  :) ";
	}

}
