package medtravBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import entities.Doctor;

@ManagedBean
@ViewScoped
public class admin_doctors_selectionView {
	
	
	private List<Doctor> allDoctors;
	private Doctor selectedDoc = new Doctor();
	
	@ManagedProperty(value = "#{userBean}")
	private UserBean service;

	@PostConstruct
	public void init() {
		setAllDoctors(service.getDoctors());

	}

	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Doctor Selected",
				((Doctor) event.getObject()).getFirstName()+" "+((Doctor)event.getObject()).getLastName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	
		
		
		
		
		//Insertion booking doctor
	//	service.doBookDoctor((Doctor) event.getObject()); 
		
	}

	public void onRowUnselect(UnselectEvent event) {
		FacesMessage msg = new FacesMessage("Doctor Unselected",
				((Doctor) event.getObject()).getFirstName()+" "+((Doctor)event.getObject()).getLastName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	

	
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Doctor edited", ((Doctor) event.getObject()).getFirstName()+" "+((Doctor)event.getObject()).getLastName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        service.doUpdateDoctor((Doctor) event.getObject());
        
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled",((Doctor) event.getObject()).getFirstName()+" "+((Doctor)event.getObject()).getLastName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
	
	
	public UserBean getService() {
		return service;
	}

	public void setService(UserBean service) {
		this.service = service;
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
}
