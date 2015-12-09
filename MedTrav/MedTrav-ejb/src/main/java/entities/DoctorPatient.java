package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: DoctorPatient
 *
 */
@Entity
@Table(name = "T_DOCTORPATIENT")
public class DoctorPatient implements Serializable {

	private DoctorPatientID id;

	private static final long serialVersionUID = 1L;

	private Booking booking;
	private Doctor doctor;
	private Patient patient;

	public DoctorPatient() {
		super();
	}

	
	
	
	@Override
	public String toString() {
		return "DoctorPatient [id=" + id + "]";
	}




	public DoctorPatient(Doctor doctor, Patient patient) {
		super();
		this.id= new DoctorPatientID(patient.getUserId(), doctor.getUserId());
		this.doctor = doctor;
		this.patient = patient;
	}




	@EmbeddedId
	public DoctorPatientID getId() {
		return id;
	}

	public void setId(DoctorPatientID id) {
		this.id = id;
	}

	@OneToOne(mappedBy = "doctorPatient")
	public Booking getBookings() {
		return booking;
	}

	public void setBookings(Booking booking) {
		this.booking = booking;
	}

	@ManyToOne
	@JoinColumn(name = "doctorId", referencedColumnName = "userId", insertable = false, updatable = false)
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@ManyToOne
	@JoinColumn(name = "patientId", referencedColumnName = "userId", insertable = false, updatable = false)
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
