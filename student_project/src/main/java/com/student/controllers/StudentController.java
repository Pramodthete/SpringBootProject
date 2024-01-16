package com.student.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.daos.StudentDao;
import com.student.entities.Student;

@RestController
@CrossOrigin
public class StudentController {
	@Autowired
	public StudentDao sdao;
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return sdao.findAll();
	}
	
	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable Long studentId) {
		return sdao.findById(studentId).orElseThrow();
	}
	
	@PostMapping("/student")
	public Student InsertStudent(@RequestBody Student s) {
		return sdao.save(s);
	}
	
	
	@PutMapping("/student/{sid}")
	public Student saveStudent(@RequestBody Student s,@PathVariable Long sid) {
		Student stu = sdao.findById(sid).orElseThrow();
		stu.setFirstName(s.getFirstName());
		stu.setLastName(s.getLastName());
		stu.setGender(s.getGender());
		stu.setEmail(s.getEmail());
		stu.setPhoneNumber(s.getPhoneNumber());
		return sdao.save(stu);
	}
	
	
	@DeleteMapping("/student/{studentId}")
	public void removeStudent(@PathVariable Long studentId) {
		sdao.deleteById(studentId);
	}

	
	
}
