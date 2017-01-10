package br.com.finance.controll.backend.api;

import java.util.List;

import br.com.finance.controll.backend.model.Student;

public interface StudentService {

	List<Student> listStudents();
	
	void createStudent(Student student);
}
