package com.example.demo.Services3;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

//import java.util.Optional;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.UnauthorizedAccessException;
import com.example.demo.Model.DepartmentAdmin;
import com.example.demo.Model.LoginUser;
import com.example.demo.Model.Ndcapply_Form;

import com.example.demo.Model.Student;

import com.example.demo.Repository.DepartmentAdminRepository;
import com.example.demo.Repository.LoginUserRepository;
import com.example.demo.Repository.NoduesFormRepository;
import com.example.demo.Repository.NoduesRepository;

@Service
public class implNoduesServices implements NoduesServices{
	
	@Autowired
	private NoduesRepository noduesRepository;
	
	@Autowired
	private DepartmentAdminRepository departmentAdminRepository;

	

	@Autowired
	public implNoduesServices(NoduesFormRepository noduesFormRepository) {
		super();
		this.noduesFormRepository = noduesFormRepository;
	}



	public implNoduesServices(NoduesRepository noduesRepository) {
		super();
		this.noduesRepository = noduesRepository;
	}
	
	
	
	public implNoduesServices(LoginUserRepository loginUserRepository) {
		super();
		this.loginUserRepository = loginUserRepository;
	}


//	student
	@Override
	public Student addStudent(Student student) {
		return noduesRepository.save(student);
	
	}
	@Override
	public Student getStudentByID(Long id) {
		Optional<Student>student=noduesRepository.findById(id);
		if(student.isPresent()) {
			
			return student.get();
		}
		return student.orElseThrow(() -> new NoSuchElementException("Student not found with ID: " + id));

	}
	@Override
	public List<Student> getAllstudents() {
		return noduesRepository.findAll();
	}
	@Override
	public Student deleteStudentById(Long id) {
		 Optional<Student> student = noduesRepository.findById(id);
		    if (student.isPresent()) {
		        noduesRepository.deleteById(id);
		        return student.get();
		    }
		    throw new NoSuchElementException("Student not found with ID: " + id);
	}
	
	@Override
	public void deleteAllStudents() {
		noduesRepository.deleteAll();
		
	}


	//department admin operation
	@Override
	public DepartmentAdmin saveDept(DepartmentAdmin departmentAdmin) {
		
		return departmentAdminRepository.save(departmentAdmin);
	}



	@Override
	public List<DepartmentAdmin> allDepartment() {
		
		return departmentAdminRepository.findAll();
	}
	

}