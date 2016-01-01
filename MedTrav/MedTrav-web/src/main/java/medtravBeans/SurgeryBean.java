package medtravBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContextWrapper;

import org.primefaces.event.SelectEvent;

import services.interfaces.SurgeryServicesLocal;
import services.interfaces.UserServicesLocal;
import entities.Surgery;
import entities.User;

@ManagedBean
@SessionScoped
public class SurgeryBean {

	private List<Surgery> surgeries;
	private Surgery selectedSurgery = new Surgery();

	@EJB
	private SurgeryServicesLocal surgeryService;

	@EJB
	private UserServicesLocal userServices;
	
	
	@ManagedProperty(value = "#{loginBean.found}")
	private User user;

	public void doBookSurgery(Surgery surgery) {
		addMessage("Surgery booked", surgery.getName() + " has been booked.");
		userServices.bookSurgery(surgery, " ", user.getUserId());

	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, detail);
		FacesContextWrapper.getCurrentInstance().addMessage(null, message);
	}

	public String onRowSelect(SelectEvent event) {

		// Booking :
		addMessage("Surgery booked", ((Surgery) event.getObject()).getName()
				+ " has been booked.");
		doBookSurgery((Surgery) event.getObject());
		// return "patient_listOfDoctors"; // la redirection ne marche pas je
		// sais pas prk :3
		return "patient_listOfDoctors?faces-redirect=true";
	}

	public List<Surgery> getSurgeries() {
		return surgeryService.findAllSurgeries();
	}

	public void setSurgeries(List<Surgery> surgeries) {
		this.surgeries = surgeries;
	}

	public Surgery getSelectedSurgery() {
		return selectedSurgery;
	}

	public void setSelectedSurgery(Surgery selectedSurgery) {
		this.selectedSurgery = selectedSurgery;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
