package quanlythuvien.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import quanlythuvien.model.User;

/*
 *@author: nguyenkhue
 *@version 1.0 Nov 19, 2015
 */
@Repository("loginDAO")
public class LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	//Get user dựa vào username
	public User getUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		Transaction ts = session.beginTransaction();
		ts.setTimeout(5);
		Criteria crit = session.createCriteria(User.class);
		crit.add(Restrictions.eq("userName", user.getUserName()));
		crit.setMaxResults(1);
		User u = (User) crit.uniqueResult();
		ts.commit();
		return u;
	}
}
