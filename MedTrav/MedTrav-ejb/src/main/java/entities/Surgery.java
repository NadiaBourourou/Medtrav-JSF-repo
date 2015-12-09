package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Surgery
 *
 */
@Entity
@Table(name = "t_surgery")
public class Surgery implements Serializable {

	private Integer surgeryId;
	private String name;
	private String description;
	private Double price;
	private Date date;

	private Doctor doctor;
	private List<SurgeryPatient> surgeryPatients;
	private Procedure procedure;

	private static final long serialVersionUID = 1L;

	public Surgery() {
		super();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getSurgeryId() {
		return surgeryId;
	}

	public void setSurgeryId(Integer surgeryId) {
		this.surgeryId = surgeryId;
	}

	@ManyToOne
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@OneToMany(mappedBy = "surgery")
	public List<SurgeryPatient> getSurgeryPatients() {
		return surgeryPatients;
	}

	public void setSurgeryPatients(List<SurgeryPatient> surgeryPatients) {
		this.surgeryPatients = surgeryPatients;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	public Procedure getProcedure() {
		return procedure;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}


	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
