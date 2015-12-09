package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tip
 *
 */
@Entity
@Table(name="T_TIP")
public class Tip implements Serializable {

	
	private Integer idTip;
	private String title;
	private String body;
	private Integer liked;
	private Integer disliked;
	private Integer idPatientVoted;
	
	private Administrator administrator;
	private List<Favorite> favorites;
	
	private static final long serialVersionUID = 1L;

	public Tip() {
		super();
	}   
	
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdTip() {
		return this.idTip;
	}

	public void setIdTip(Integer idTip) {
		this.idTip = idTip;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}   
	public Integer getLiked() {
		return this.liked;
	}

	public void setLiked(Integer liked) {
		this.liked = liked;
	}   
	public Integer getDisliked() {
		return this.disliked;
	}

	public void setDisliked(Integer disliked) {
		this.disliked = disliked;
	}   
	public Integer getIdPatientVoted() {
		return this.idPatientVoted;
	}

	public void setIdPatientVoted(Integer idPatientVoted) {
		this.idPatientVoted = idPatientVoted;
	}

	@ManyToOne
	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	@ManyToMany(mappedBy="tips")
	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}
   
}
