package com.example.TestContainers_demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.testcontainers.containers.PostgreSQLContainer;

import com.example.TestContainers_demo.entities.Student;
import com.example.TestContainers_demo.repositroy.StudentRepository;

@SpringBootTest
@Profile("test")
class TestContainersDemoApplicationTests {

    private static final PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:15")
            .withDatabaseName("testcontainer")
            .withUsername("postgres")
            .withPassword("test");

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    public void setUp() {
        if (!postgresContainer.isRunning()) {
            postgresContainer.start();
        }

        Student student1 = new Student();
        student1.setId((long) 1);
        student1.setName("Santhosh");
        studentRepository.save(student1);

        Student student2 = new Student();
        student1.setId((long) 2);
        student2.setName("Santhosh");
        studentRepository.save(student2);
    }

    @Test
    void testSaveStudent() {
        Student student = new Student();
        student.setId((long) 3);
        student.setName("Santhosh");

        Student savedStudent = studentRepository.save(student);

        assertNotNull(savedStudent);
        assertTrue(savedStudent.getId() > 0);
    }

    @Test
    void testGetAllStudents() {
        List<Student> students = studentRepository.findAll();
        assertTrue(students.size() > 0);
    }
}
