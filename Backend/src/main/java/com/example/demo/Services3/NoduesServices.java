 package com.example.demo.Services3;

import java.util.List;

import org.springframework.stereotype.Service;





import com.example.demo.Model.Student;
@Service
public interface NoduesServices {
	//for student operation
	Student addStudent(Student student);
	Student getStudentByID(Long id);
	List<Student>getAllstudents();
	public Student deleteStudentById(Long id);
	void deleteAllStudents();
	Student updateStudent(Long id,Student student);
	
	//Department Admin
	public boolean isUserDepartmentAdmin(Long departmentId);
	DepartmentAdmin saveDept(DepartmentAdmin departmentAdmin);
	List<DepartmentAdmin>allDepartment();

	
	
	
}
