package net.tmhub.obj;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author remal
 */
@Entity
public class Prog implements Serializable {

	@Id
        @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	

	@OneToMany(mappedBy = "prog", fetch = FetchType.EAGER)
	private Set<State> states;
}
