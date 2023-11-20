package com.example.demo.Controller;

import java.util.List;

import javax.security.auth.login.LoginContext;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.DepartmentAdmin;
import com.example.demo.Model.LoginUser;
import com.example.demo.Model.Ndcapply_Form;

import com.example.demo.Model.Student;
import com.example.demo.Repository.LoginUserRepository;
import com.example.demo.Services3.NoduesServices;
import com.example.demo.Services3.StudentIdService;
@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/api/nodues") //url 
public class NDCController {
	
	@Autowired
	private NoduesServices noduesServices;

	public NDCController(NoduesServices noduesServices) {
		super();
		this.noduesServices = noduesServices;
		
	}
	@Autowired
	private StudentIdService studentIdService;
	
	public NDCController(StudentIdService studentIdService) {
		super();
		this.studentIdService = studentIdService;
	}




//	deafault constructor
	public NDCController() {
		
	}

	

//	add stduent details
	@PostMapping("/student")
	public ResponseEntity<Student>saveStudent(@RequestBody Student student){
		return new ResponseEntity<Student>(noduesServices.addStudent(student),HttpStatus.CREATED);
	}
	
	

	//	get student details
	@GetMapping("/student/{id}")
	public ResponseEntity<Student>getStudent(@PathVariable("id")Long id){
		return new ResponseEntity<Student>(noduesServices.getStudentByID(id),HttpStatus.OK);
	}
	
	//get all student or view students
	@GetMapping("/viewstudents")
	public ResponseEntity<List<Student>>ViewStudents(){
		return new ResponseEntity<>(noduesServices.getAllstudents(),HttpStatus.OK);
	}
	//delete students by id
	@DeleteMapping("/deletestudent/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") Long id) {
	    return new ResponseEntity<>(noduesServices.deleteStudentById(id), HttpStatus.OK);
	}
	//delete all students
	@DeleteMapping("/deletestudents")
	public ResponseEntity<String> deleteAllStudents() {
	    noduesServices.deleteAllStudents();
	    return new ResponseEntity<>("Deleted All Students", HttpStatus.OK);
	}
	@PutMapping("/student/edit/{id}")
	public ResponseEntity<Student>UpdateStudent(@RequestBody Student student,@PathVariable("id")Long id){
		
		return new ResponseEntity<Student>(noduesServices.updateStudent(id, student),HttpStatus.OK);
	}


//getallforms for department admin
	@GetMapping("/ndcforms")
	public ResponseEntity<List<Ndcapply_Form>>getForms(){
		return new ResponseEntity<List<Ndcapply_Form>>(noduesServices.getAllForms(),HttpStatus.OK);
	}
	@PutMapping("/forms/{formId}/status/{status}")
	public ResponseEntity<Ndcapply_Form>updateStatus(@PathVariable Long formId,@PathVariable String status,@RequestParam Long deptId){
		try {
		if(departmentAdminHasAuthority(deptId))
		{
		Ndcapply_Form updateForm=noduesServices.updateFormStatus(formId, status,deptId);
		return ResponseEntity.ok(updateForm);
		}else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}catch(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	}
	private boolean departmentAdminHasAuthority(Long departmentId) {
        
        return noduesServices.isUserDepartmentAdmin(departmentId);
    }

	
	
