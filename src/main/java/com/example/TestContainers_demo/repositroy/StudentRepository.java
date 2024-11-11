package com.example.TestContainers_demo.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TestContainers_demo.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>  {

}
