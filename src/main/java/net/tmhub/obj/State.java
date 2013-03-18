package net.tmhub.obj;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author remal
 */
@Entity
public class State {

	@Id
        @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private boolean value;
	private char state;
	private boolean nextValue;
	private char nextState;

	@ManyToOne(fetch = FetchType.EAGER)
	private TM tm;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the value
	 */
	public boolean isValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(boolean value) {
		this.value = value;
	}

	/**
	 * @return the state
	 */
	public char getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(char state) {
		this.state = state;
	}

	/**
	 * @return the nextValue
	 */
	public boolean isNextValue() {
		return nextValue;
	}

	/**
	 * @param nextValue the nextValue to set
	 */
	public void setNextValue(boolean nextValue) {
		this.nextValue = nextValue;
	}

	/**
	 * @return the nextState
	 */
	public char getNextState() {
		return nextState;
	}

	/**
	 * @param nextState the nextState to set
	 */
	public void setNextState(char nextState) {
		this.nextState = nextState;
	}

	/**
	 * @return the tm
	 */
	public TM getTm() {
		return tm;
	}

	/**
	 * @param tm the tm to set
	 */
	public void setTm(TM tm) {
		this.tm = tm;
	}
}
