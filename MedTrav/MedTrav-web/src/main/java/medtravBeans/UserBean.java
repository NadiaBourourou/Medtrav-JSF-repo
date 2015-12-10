package medtravBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.interfaces.UserServicesLocal;
import entities.Patient;


@ManagedBean
@SessionScoped
public class UserBean {


	private Patient patient= new Patient();
	private String patientSignature;

	@EJB
	private UserServicesLocal userServices;

	public String doAddPatient() {
		if(userServices.addPatient(patient))
		return ""; // user registered
		
		else 
			return ""; // a problem occurred during user registration
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getPatientSignature() {
		return patientSignature;
	}

	public void setPatientSignature(String patientSignature) {
		this.patientSignature = patientSignature;
	}

	
}
