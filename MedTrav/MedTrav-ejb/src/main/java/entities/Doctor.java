package entities;

import entities.User;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Doctor
 *
 */
@Entity

public class Doctor extends User implements Serializable {

	
	private String specialty;
	private String description;
	
	private List<Surgery> surgeries;
	private List<DoctorPatient> doctorPatients;
	
	private static final long serialVersionUID = 1L;

	public Doctor() {
		super();
	}   
	public String getSpecialty() {
		return this.specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToMany(mappedBy="doctor")
	public List<Surgery> getSurgeries() {
		return surgeries;
	}
	
	public void setSurgeries(List<Surgery> surgeries) {
		this.surgeries = surgeries;
	}
	public void linkSurgeriesToThisDoctor(List<Surgery> surgeries) {
		this.surgeries = surgeries;
		for (Surgery s : surgeries) {
			s.setDoctor(this);
		}
	}
	
	@OneToMany(mappedBy="doctor")
	public List<DoctorPatient> getDoctorPatients() {
		return doctorPatients;
	}
	public void setDoctorPatients(List<DoctorPatient> doctorPatients) {
		this.doctorPatients = doctorPatients;
	}

   
}
