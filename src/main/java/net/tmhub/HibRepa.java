package net.tmhub;

import java.io.Serializable;
import net.tmhub.obj.Profile;
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
		Profile p =	(Profile)sf.
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
		Profile p = (Profile)sf.getCurrentSession().load(Profile.class, id);
		return p;
	}

	@Override
	@Transactional
	public void saveProfile(Profile profile) {
		sf.getCurrentSession().save(profile);
		log.info("profile id=%s", profile.getId());
	}
}
