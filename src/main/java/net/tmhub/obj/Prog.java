package net.tmhub.obj;

import java.io.Serializable;
import java.util.TreeSet;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author remal
 */
@Entity
public class Prog implements Serializable {

	@Id
        @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	@ManyToMany
	private TreeSet<State> states;

}
