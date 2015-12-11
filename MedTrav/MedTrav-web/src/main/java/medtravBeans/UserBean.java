package medtravBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.interfaces.UserServicesLocal;
import entities.Doctor;
import entities.Patient;
import entities.RoleType;

@ManagedBean
@SessionScoped
public class UserBean {

	private Patient patient = new Patient();
	private Doctor doctor = new Doctor();
	private String patientSignature;
	private List<Doctor> doctors;
	
	private Boolean diplayAddDoctorForm=false;

	@EJB
	private UserServicesLocal userServices;

	public String doAddPatient() {
		patient.setRole(RoleType.PATIENT);
		if (userServices.addPatient(patient))
			return ""; // user registered

		else
			return ""; // a problem occurred during user registration
	}
	
	public void displayForm()
	{
		diplayAddDoctorForm = true;
		}
	
	public String doAddDoctor(){
	doctor.setRole(RoleType.DOCTOR);
	doctor.setLogin(doctor.getFirstName()+"."+doctor.getLastName());
	doctor.setPassword("pwd"+doctor.getFirstName());
	userServices.addDocor(doctor);
	
	diplayAddDoctorForm=false;
	return "admin_listOfDoctors";
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

	public Boolean getDiplayAddDoctorForm() {
		return diplayAddDoctorForm;
	}

	public void setDiplayAddDoctorForm(Boolean diplayAddDoctorForm) {
		this.diplayAddDoctorForm = diplayAddDoctorForm;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	

}
