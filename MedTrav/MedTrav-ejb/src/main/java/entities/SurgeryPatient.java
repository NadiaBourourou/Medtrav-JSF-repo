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
 * Entity implementation class for Entity: SurgeryPatient
 *
 */
@Entity
@Table(name = "t_SURGERYPATIENT")
public class SurgeryPatient implements Serializable {

	private SurgeryPatientID surgeryPatientID;
	private String commentaire;
	private String price;
	private static final long serialVersionUID = 1L;

	private Patient patient;
	private Surgery surgery;
	private Booking booking;

	public SurgeryPatient() {
		super();
	}

	public SurgeryPatient(SurgeryPatientID surgeryPatientID, String commentaire) {
		super();
		this.surgeryPatientID = surgeryPatientID;
		this.commentaire = commentaire;
	}

	@EmbeddedId
	public SurgeryPatientID getSurgeryPatientID() {
		return surgeryPatientID;
	}

	public void setSurgeryPatientID(SurgeryPatientID surgeryPatientID) {
		this.surgeryPatientID = surgeryPatientID;
	}

	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@ManyToOne
	@JoinColumn(name = "idPatient", referencedColumnName = "userId", insertable = false, updatable = false)
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@ManyToOne
	@JoinColumn(name = "idSurgery", referencedColumnName = "surgeryId", insertable = false, updatable = false)
	public Surgery getSurgery() {
		return surgery;
	}

	public void setSurgery(Surgery surgery) {
		this.surgery = surgery;
	}

	@OneToOne(mappedBy = "surgeryPatient")
	public Booking getBookings() {
		return booking;
	}

	public void setBookings(Booking booking) {
		this.booking = booking;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
