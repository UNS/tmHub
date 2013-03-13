package net.tmhub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;

/**
 *
 * @author remal
 */
@Repository
public class HibRepa implements Repa {
	
	private SessionFactory sf;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	@Transactional
	public void saveMe() {
		Hi hi = new Hi();
		hi.setTest("42");
		sf.getCurrentSession().saveOrUpdate(hi);
	}

	@Override
	@Transactional
	public String helloWorld() {
		Hi h = (Hi)sf.getCurrentSession().load(Hi.class, 1L);
		return h.getTest();
	}
}
