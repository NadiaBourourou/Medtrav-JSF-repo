package medtravBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import services.interfaces.UserServicesLocal;
import entities.Administrator;
import entities.Doctor;
import entities.Patient;
import entities.User;

@ManagedBean (name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;

	private String password;
	private String username;
	private User found;
	boolean loggedIn = false;

	@EJB
	private UserServicesLocal userServices;

	public String doLogin() {
		String navigateTo = null;
		 found = userServices.userIdentification(username,password);
	
			if(found instanceof Administrator){
				navigateTo = "/admin/home?faces-redirect=true";
			}else if (found instanceof Patient) {
				navigateTo = "/patient/home?faces-redirect=true";
			}
			else if (found instanceof Doctor) {
				navigateTo = "/doctor/home?faces-redirect=true";
			}
		else {
			FacesContext
			.getCurrentInstance()
			.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Wrong credentials.",
					null
					
			));
		}
		return navigateTo;

	}

	public String logout() {

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "login.jsf?faces-redirect=true";
	}
	
	public Boolean hasRole(String role) {
		Boolean response = false;
		switch (role) {
		case "Admin":
			response = found instanceof Administrator;
			break;
		case "Doc":
			response = found instanceof Doctor;
			break;
		case "Patient":
			response = found instanceof Patient;
			break;
		
		}
		return response;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}



	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public User getFound() {
		return found;
	}

	public void setFound(User found) {
		this.found = found;
	}



}
