package com.example.TestContainers_demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.TestContainers_demo.entities.Student;
import com.example.TestContainers_demo.repositroy.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public Student saveStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}

	public List<Student> getAll() {
		return studentRepository.findAll();
		
	}
}
