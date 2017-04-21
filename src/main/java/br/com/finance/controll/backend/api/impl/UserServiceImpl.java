package br.com.finance.controll.backend.api.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.finance.controll.backend.api.UserService;
import br.com.finance.controll.backend.business.UserBusiness;
import br.com.finance.controll.backend.model.User;
import br.com.finance.controll.backend.validator.UserValidator;

@Component
@Path("/users")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private UserBusiness userBusiness;

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> listUsers() {
		int i = 0;
		i = i++ + i + ++i;
		System.out.println("i: " + i);
		userValidator.validate();
		return userBusiness.listUsers();
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createUser(User student) {
		userBusiness.createUser(student);
	}

}
