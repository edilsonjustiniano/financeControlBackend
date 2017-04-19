package br.com.finance.controll.backend.business;

import java.util.List;

import br.com.finance.controll.backend.dao.UserDao;
import br.com.finance.controll.backend.model.User;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserBusiness {

	private final UserDao userDao;

	public UserBusiness(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public List<User> listUsers(){
		return userDao.getAll();
	}

	public void createUser(User user) {
		userDao.save(user);
	}
}
