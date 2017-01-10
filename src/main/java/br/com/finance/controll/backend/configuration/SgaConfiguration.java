package br.com.finance.controll.backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.finance.controll.backend.api.StudentService;
import br.com.finance.controll.backend.api.impl.StudentServiceImpl;
import br.com.finance.controll.backend.business.StudentBusiness;
import br.com.finance.controll.backend.dao.StudentDao;
import br.com.finance.controll.backend.validator.StudentValidator;

@Configuration
@EnableTransactionManagement
@Import({ SgaDatabaseConfiguration.class })
@ComponentScan(value = "br.com.finance.controll.backend.api.impl")
public class SgaConfiguration {

	@Bean
	public StudentService studentService() {
		return new StudentServiceImpl();
	}

	@Bean
	public StudentDao studentDao() {
		return new StudentDao();
	}

	@Bean
	public StudentValidator studentValidator() {
		return new StudentValidator();
	}

	@Bean
	public StudentBusiness studentBusiness(StudentDao studentDao) {
		return new StudentBusiness(studentDao);
	}

}
