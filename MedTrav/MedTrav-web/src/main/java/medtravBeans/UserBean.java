package medtravBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContextWrapper;

import services.interfaces.UserServicesLocal;
import entities.Doctor;
import entities.Patient;
import entities.RoleType;
import entities.User;

@ManagedBean
@SessionScoped
public class UserBean {

	private Patient patient = new Patient();
	private Doctor doctor = new Doctor();
	private String patientSignature;
	private List<Doctor> doctors;

	private Boolean diplayAddDoctorForm = false;

	@EJB
	private UserServicesLocal userServices;

	@ManagedProperty(value = "#{loginBean.found}")
	private User user;

	public String doAddPatient() {
		patient.setRole(RoleType.PATIENT);
		if (userServices.addPatient(patient))
			return ""; // user registered

		else
			return ""; // a problem occurred during user registration
	}

	public void displayForm() {
		diplayAddDoctorForm = true;
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, detail);
		FacesContextWrapper.getCurrentInstance().addMessage(null, message);
	}

	public String doAddDoctor() {
		doctor.setRole(RoleType.DOCTOR);
		doctor.setLogin(doctor.getFirstName() + "." + doctor.getLastName());
		doctor.setPassword("pwd" + doctor.getFirstName());
		userServices.addDocor(doctor);
		 	
		// doctors.add(doctor);
		diplayAddDoctorForm = false;
		return "admin_listOfDoctors";
	}

	public String doUpdateDoctor(Doctor doctor) {

		userServices.updateDoctor(doctor);
		return "";
	}

	public String doBookDoctor(Doctor doctor) {
		addMessage("Doctor booked", "Dr. " + doctor.getLastName()
				+ " has been notified.");
		userServices.chooseDoctor(doctor, user.getUserId());
		return "patient_listOfSurgeries";

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
