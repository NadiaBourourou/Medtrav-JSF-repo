package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Favorite
 *
 */
@Entity
@Table(name = "T_FAVORITE")
public class Favorite implements Serializable {

	private Integer idFavorite;
	private String nameFavorite;

	private List<Tip> tips;
	private Patient patient;

	private static final long serialVersionUID = 1L;

	public Favorite() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdFavorite() {
		return this.idFavorite;
	}

	public void setIdFavorite(Integer idFavorite) {
		this.idFavorite = idFavorite;
	}

	public String getNameFavorite() {
		return this.nameFavorite;
	}

	public void setNameFavorite(String nameFavorite) {
		this.nameFavorite = nameFavorite;
	}

	@ManyToMany
	public List<Tip> getTips() {
		return tips;
	}

	public void setTips(List<Tip> tips) {
		this.tips = tips;
	}

	@ManyToOne
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
