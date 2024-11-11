package com.example.TestContainers_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestContainers_demo.entities.Student;
import com.example.TestContainers_demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("/save")
	public Student save(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@GetMapping("/getAll") 
	public List<Student> getAll(){
		return studentService.getAll();
	}
	
}
