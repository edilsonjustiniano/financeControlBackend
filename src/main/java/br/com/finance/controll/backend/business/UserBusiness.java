package br.com.finance.controll.backend.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.finance.controll.backend.dao.UserDao;
import br.com.finance.controll.backend.model.User;

@Transactional
public class UserBusiness {

	private final UserDao userDao;

	public UserBusiness(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<User> listUsers() {
		return userDao.getAll();
	}

	public void createUser(User user) {
		userDao.save(user);
	}
}
