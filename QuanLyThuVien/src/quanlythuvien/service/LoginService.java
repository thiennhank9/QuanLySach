package quanlythuvien.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import quanlythuvien.dao.LoginDAO;
import quanlythuvien.model.User;
/*
 *@author: nguyenkhue
 *@version 1.0 Nov 19, 2015
 */
@Service("loginService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LoginService {
	
	@Autowired
	LoginDAO loginDao;
	
	//Get fullName dựa vào username
	public String getUserFullName(String username ){
		User user = new User();
		user.setUserName(username);
		User u = loginDao.getUser(user);
		if(u == null){
			return null;
		}
		else
			return u.getFullName();
	}
}
