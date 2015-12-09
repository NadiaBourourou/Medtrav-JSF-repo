package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Question
 *
 */
@Entity
@Table(name = "T_QUESTION")
public class Question implements Serializable {

	
	private Integer questionId;
	private String title;
	private String description;
	private Date date;
	private String response;
	
	private Patient patient;
	
	private static final long serialVersionUID = 1L;
	
	public Question() {
		super();
	}   
	
	@Id    
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}   
	public String getResponse() {
		return this.response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	@ManyToOne
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
   
}
