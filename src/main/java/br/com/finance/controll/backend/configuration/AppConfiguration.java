package br.com.finance.controll.backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.finance.controll.backend.api.UserService;
import br.com.finance.controll.backend.api.impl.UserServiceImpl;
import br.com.finance.controll.backend.business.UserBusiness;
import br.com.finance.controll.backend.dao.UserDao;
import br.com.finance.controll.backend.validator.UserValidator;

@Configuration
@EnableTransactionManagement
@Import({ AppDatabaseConfiguration.class })
@ComponentScan(value = "br.com.finance.controll.backend.api.impl")
public class AppConfiguration {

	@Bean
	public UserService studentService() {
		return new UserServiceImpl();
	}

	@Bean
	public UserDao studentDao() {
		return new UserDao();
	}

	@Bean
	public UserValidator studentValidator() {
		return new UserValidator();
	}

	@Bean
	public UserBusiness studentBusiness(UserDao studentDao) {
		return new UserBusiness(studentDao);
	}

}
