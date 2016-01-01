package medtravBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextWrapper;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import services.interfaces.UserServicesLocal;
import entities.Doctor;
import entities.User;

@ManagedBean
@SessionScoped
public class admin_doctors_selectionView {

	private List<Doctor> allDoctors;
	private Doctor selectedDoc = new Doctor();
	
	@ManagedProperty(value = "#{userBean}")
	private UserBean docservices;
	@EJB
	private UserServicesLocal service;

	@ManagedProperty(value = "#{loginBean.found}")
	private User user;

	@PostConstruct
	public void init() {
		setAllDoctors(service.findAllDoctors());

	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, detail);
		FacesContextWrapper.getCurrentInstance().addMessage(null, message);
	}

	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Doctor Selected",
				((Doctor) event.getObject()).getFirstName() + " "
						+ ((Doctor) event.getObject()).getLastName());
		FacesContext.getCurrentInstance().addMessage(null, msg);

		// Booking :
		addMessage("Doctor booked",
				"Dr. " + ((Doctor) event.getObject()).getLastName()
						+ " has been notified.");
		doBookDoctor((Doctor) event.getObject());

	}

	public void doBookDoctor(Doctor doctor) {
		addMessage("Doctor booked", "Dr. " + doctor.getLastName()
				+ " has been notified.");
		service.chooseDoctor(doctor, user.getUserId());

	}

	public void onRowUnselect(UnselectEvent event) {
		FacesMessage msg = new FacesMessage("Doctor Unselected",
				((Doctor) event.getObject()).getFirstName() + " "
						+ ((Doctor) event.getObject()).getLastName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Doctor edited",
				((Doctor) event.getObject()).getFirstName() + " "
						+ ((Doctor) event.getObject()).getLastName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		docservices.doUpdateDoctor((Doctor) event.getObject());
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled",
				((Doctor) event.getObject()).getFirstName() + " "
						+ ((Doctor) event.getObject()).getLastName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public List<Doctor> getAllDoctors() {
		return allDoctors;
	}

	public void setAllDoctors(List<Doctor> allDoctors) {
		this.allDoctors = allDoctors;
	}

	public Doctor getSelectedDoc() {
		return selectedDoc;
	}

	public void setSelectedDoc(Doctor selectedDoc) {
		this.selectedDoc = selectedDoc;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserBean getDocservices() {
		return docservices;
	}

	public void setDocservices(UserBean docservices) {
		this.docservices = docservices;
	}
	
	
}
