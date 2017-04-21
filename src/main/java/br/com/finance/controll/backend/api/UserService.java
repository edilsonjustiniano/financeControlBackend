package br.com.finance.controll.backend.api;

import java.util.List;

import br.com.finance.controll.backend.model.User;

public interface UserService {

	List<User> listUsers();

	void createUser(User user);
}
