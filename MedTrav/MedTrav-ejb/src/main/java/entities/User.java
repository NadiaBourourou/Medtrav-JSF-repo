 package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name="T_USER")
public class User implements Serializable {

	
	private Integer userId;
	private String lastName;
	private String firstName;
	private String cin;
	private String login;
	private String password;
	private RoleType role;
	private String mail;
	private UserSexe sexe;
	
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}  
	
	
	
	
	public User(String lastName, String firstName, String cin, String mail) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.cin = cin;
		this.mail = mail;
	}




	@Override
	public String toString() {
		return "User [userId=" + userId + ", lastName=" + lastName
				+ ", firstName=" + firstName + ", role=" + role + "]";
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getCin() {
		return this.cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	
	
	public RoleType getRole() {
		return role;
	}
	public void setRole(RoleType role) {
		this.role = role;
	}
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	public UserSexe getSexe() {
		return sexe;
	}
	public void setSexe(UserSexe sexe) {
		this.sexe = sexe;
	}
   
}
