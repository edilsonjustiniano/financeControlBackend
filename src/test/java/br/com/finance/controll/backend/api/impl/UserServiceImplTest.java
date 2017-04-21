package br.com.finance.controll.backend.api.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.finance.controll.backend.business.UserBusiness;
import br.com.finance.controll.backend.model.User;
import br.com.finance.controll.backend.validator.UserValidator;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

	@Mock
	private UserValidator studentValidator;

	@Mock
	private UserBusiness studentBusiness;

	@InjectMocks
	private UserServiceImpl userServiceImpl;

	@Test
	public void shouldListStudents() {
		// Given Test 123
		List<User> students = buildStudentList();
		given(studentBusiness.listUsers()).willReturn(students);

		// When
		List<User> result = userServiceImpl.listUsers();

		// Then
		assertThat(result, equalTo(students));
	}

	private List<User> buildStudentList() {
		ArrayList<User> students = new ArrayList<User>();
		User student = new User();
		student.setId(23L);
		student.setName("Sandro");
		students.add(student);
		return students;
	}

}
