package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: Patient
 *
 */
@Entity
public class Patient extends User implements Serializable {

	private Date dateOfBirth;
	private String country;
	private Integer numPassport;
	private PatientState state;
	private Boolean confirmed;

	private List<Testimony> testimonies;
	private List<Question> questions;
	private MedicalRecords medicalRecords;

	private List<HotelBooking> hotelBookings;
	private List<ClinicBooking> clinicBookings;
	private List<Flight> flights;
	private List<SurgeryPatient> surgeryPatients;
	private List<DoctorPatient> doctorPatients;
	private List<Favorite> favorites;

	private static final long serialVersionUID = 1L;

	public Patient() {
		super();
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getNumPassport() {
		return this.numPassport;
	}

	public void setNumPassport(Integer numPassport) {
		this.numPassport = numPassport;
	}

	@OneToMany(mappedBy = "patient")
	public List<Testimony> getTestimonies() {
		return testimonies;
	}

	public void setTestimonies(List<Testimony> testimonies) {
		this.testimonies = testimonies;
	}

	@OneToOne(mappedBy = "patient")
	public MedicalRecords getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(MedicalRecords medicalRecords) {
		this.medicalRecords = medicalRecords;
	}

	public PatientState getState() {
		return state;
	}

	public void setState(PatientState state) {
		this.state = state;
	}

	@OneToMany(mappedBy = "patient")
	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@OneToMany(mappedBy = "patient")
	public List<HotelBooking> getHotelBookings() {
		return hotelBookings;
	}

	public void setHotelBookings(List<HotelBooking> hotelBookings) {
		this.hotelBookings = hotelBookings;
	}

	@OneToMany(mappedBy = "patient")
	public List<ClinicBooking> getClinicBookings() {
		return clinicBookings;
	}

	public void setClinicBookings(List<ClinicBooking> clinicBookings) {
		this.clinicBookings = clinicBookings;
	}

	@OneToMany(mappedBy = "patient")
	public List<SurgeryPatient> getSurgeryPatients() {
		return surgeryPatients;
	}

	public void setSurgeryPatients(List<SurgeryPatient> surgeryPatients) {
		this.surgeryPatients = surgeryPatients;
	}
	
	@OneToMany(mappedBy = "patient")
	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	@OneToMany(mappedBy="patient")
	public List<DoctorPatient> getDoctorPatients() {
		return doctorPatients;
	}

	public void setDoctorPatients(List<DoctorPatient> doctorPatients) {
		this.doctorPatients = doctorPatients;
	}

	public Boolean getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}
	
	@OneToMany(mappedBy="patient")
	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

}
