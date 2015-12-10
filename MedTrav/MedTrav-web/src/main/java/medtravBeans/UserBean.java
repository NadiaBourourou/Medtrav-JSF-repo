package medtravBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.interfaces.UserServicesLocal;
import entities.Doctor;
import entities.Patient;

@ManagedBean
@SessionScoped
public class UserBean {

	private Patient patient = new Patient();
	private String patientSignature;

	private List<Doctor> doctors;

	@EJB
	private UserServicesLocal userServices;

	public String doAddPatient() {
		if (userServices.addPatient(patient))
			return ""; // user registered

		else
			return ""; // a problem occurred during user registration
	}
	
	public String doUpdateDoctor(Doctor doctor){
	
		userServices.updateDoctor(doctor);
		return"";
	}

	public String doBookDoctor(Doctor doctor) {
		userServices.chooseDoctor(doctor, 1);
	return "";
		
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

	public List<Doctor> getDoctors() {
		return userServices.findAllDoctors();
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

}
