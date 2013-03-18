package net.tmhub;

import java.util.List;
import net.tmhub.obj.Profile;
import net.tmhub.obj.State;
import net.tmhub.obj.TM;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author remal
 */
@Repository
public class HibRepa implements Repa {

	private SessionFactory sf;
	final private Logger log = LoggerFactory.getLogger(Repa.class);

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	@Transactional
	public Profile getProfile(String userName) {
		log.info("getProfile" + userName);
		Profile p = (Profile) sf.
			getCurrentSession().
			createCriteria(Profile.class).
			add(Restrictions.eq("login", userName)).
			uniqueResult();
		if (p == null) {
			p = new Profile();
			p.setLogin("avtogen"); //TODO change
		}
		return p;
	}

	@Override
	@Transactional
	public Profile getProfile(long id) {
		Session ses = sf.getCurrentSession();
		Profile p = new Profile();
		ses.load(p, id);
		log.info("loaded by id={}", p.toString());
		return p;
	}

	@Override
	@Transactional
	public void saveProfile(Profile profile) {
		sf.getCurrentSession().save(profile);
		log.info("saved profile id={}", profile.toString());
	}

	@Override
	@Transactional
	public void updateProfile(Profile p) {
		sf.getCurrentSession().update(p);
		log.info("updated profile id={}", p.toString());
	}

	@Override
	@Transactional
	public void deleteProfile(Profile p) {
		sf.getCurrentSession().delete(p);
		log.info("deleted profile={}", p.toString());
	}

	@Override
	@Transactional
	public List<Profile> getProfiles() {
		List<Profile> result = (List<Profile>) sf.getCurrentSession().createCriteria(Profile.class).list();
		return result;
	}

	@Override
	public void saveState(State state) {
		sf.getCurrentSession().save(state);
		log.info("saved state id={}", state.toString());
	}

	@Override
	public State getState(long id) {
		Session ses = sf.getCurrentSession();
		State state = new State();
		ses.load(state, id);
		log.info("loaded state by id={}", state.toString());
		return state;
	}

	@Override
	public List<State> getState() {
		List<State> list = (List<State>) sf.getCurrentSession().createCriteria(State.class).list();
		return list;
	}

	@Override
	public void updateState(State state) {
		sf.getCurrentSession().update(state);
		log.info("updated state id={}", state.toString());
	}

	@Override
	public void deleteState(State s) {
		sf.getCurrentSession().delete(s);
		log.info("deleted state={}", s.toString());
	}

	@Override
	public void saveTM(TM tm) {
		sf.getCurrentSession().save(tm);
		log.info("saved tm id={}", tm.toString());
	}

	@Override
	public TM getTM(long id) {
		Session ses = sf.getCurrentSession();
		TM tm = new TM();
		ses.load(tm, id);
		log.info("loaded tm by id={}", tm.toString());
		return tm;
	}

	@Override
	public List<TM> getTM() {
		List<TM> list = (List<TM>) sf.getCurrentSession().createCriteria(TM.class).list();
		return list;
	}

	@Override
	public void updateTM(TM tm) {
		sf.getCurrentSession().update(tm);
		log.info("updated tm id={}", tm.toString());
	}

	@Override
	public void deleteTM(TM tm) {
		sf.getCurrentSession().delete(tm);
		log.info("deleted tm={}", tm.toString());
	}
}
