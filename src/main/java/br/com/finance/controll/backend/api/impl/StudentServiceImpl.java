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

import br.com.finance.controll.backend.api.StudentService;
import br.com.finance.controll.backend.business.StudentBusiness;
import br.com.finance.controll.backend.model.Student;
import br.com.finance.controll.backend.validator.StudentValidator;

@Component
@Path("/students")
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentValidator studentValidator;
	
	@Autowired
	private StudentBusiness studentBusiness;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> listStudents() {
		studentValidator.validateStudy();
		return studentBusiness.listStudents();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createStudent(Student student) {
		studentBusiness.createStudent(student);
	}

}
