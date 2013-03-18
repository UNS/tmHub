package net.tmhub.obj;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author remal
 */
@Entity
public class TM implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
        @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Problem problem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof TM)) {
			return false;
		}
		TM other = (TM) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "net.tmhub.obj.TM[ id=" + id + " ]";
	}
	
}
