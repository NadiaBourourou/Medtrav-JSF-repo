package medtravBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;

import services.interfaces.AssignedPatientsServicesLocal;
import services.interfaces.UserServicesLocal;
import entities.Patient;
import entities.User;




@ManagedBean
@SessionScoped
public class DoctorBean {

	// models
		private Patient patient = new Patient();
		private List<Patient> patients;
		
		private boolean display = false;
		private String titleSearch;
		
		// injection of the proxy
		@EJB
		private AssignedPatientsServicesLocal patientServicesLocal;
		@EJB
		private UserServicesLocal userServicesLocal;
		
		@ManagedProperty(value = "#{loginBean.found}")
		private User user;
		
		@PostConstruct
		public void init() {
			patient=new Patient();
			setPatients(patientServicesLocal.findAllPatientsByDoctorId(4));
			setDisplay(false);

		}
		public void onRowSelect(SelectEvent event) {
			setDisplay(true);
		}
		
		
		// methods
	public String doAcceptPatient(){
		patientServicesLocal.acceptPatient(patient);
	patients=patientServicesLocal.findAllPatientsByDoctorId(user.getUserId());
	patient=new Patient();
	display=false;
	return "";
	}
	public String doRefusePatient(){
		
	patientServicesLocal.refusePatient(patient, user.getUserId());
	patients=patientServicesLocal.findAllPatientsByDoctorId(user.getUserId());
	patient=new Patient();
	display=false;
	return "";
	}
		
		

		public Patient getPatient() {
			if(patient == null){
				patient = new Patient();
				}
			return patient;
		}

		public void setPatient(Patient question) {
			this.patient = question;
		}

		
		

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public boolean isDisplay() {
			return display;
		}

		public void setDisplay(boolean display) {
			this.display = display;
		}

		public String getTitleSearch() {
			return titleSearch;
		}

		public void setTitleSearch(String titleSearch) {
			this.titleSearch = titleSearch;
		}
		public List<Patient> getPatients() {
			return patients;
		}
		public void setPatients(List<Patient> patients) {
			this.patients = patients;
		}
		
		
	
		

	

		
}
