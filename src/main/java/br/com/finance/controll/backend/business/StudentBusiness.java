package br.com.finance.controll.backend.business;

import java.util.List;

import br.com.finance.controll.backend.dao.StudentDao;
import br.com.finance.controll.backend.model.Student;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StudentBusiness {

	private final StudentDao studentDao;

	public StudentBusiness(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public List<Student> listStudents(){
		return studentDao.getAll();
	}

	public void createStudent(Student student) {
		studentDao.save(student);
	}
}
