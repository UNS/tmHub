package net.tmhub.obj;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


/**
 *
 * @author remal
 */

@Entity
public class State {
	@ManyToMany(mappedBy = "states")
	private List<Prog> progs;
	@Id
        @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private Prog prog;
}
