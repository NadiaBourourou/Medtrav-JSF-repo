package entities;

import entities.User;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Administrator
 *
 */
@Entity


public class Administrator extends User implements Serializable {

	private List<Tip> tips;
	
	private static final long serialVersionUID = 1L;

	public Administrator() {
		super();
	}

	@OneToMany(mappedBy = "administrator")
	public List<Tip> getTips() {
		return tips;
	}

	public void setTips(List<Tip> tips) {
		this.tips = tips;
	}
   
}
