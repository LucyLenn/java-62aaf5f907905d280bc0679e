package ua.hillel.homeworks.homework31.persistent.dao;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import ua.hillel.homeworks.homework31.persistent.entity.Student;
import ua.hillel.homeworks.homework31.persistent.service.StudentDaoService;

import java.util.List;
import java.util.Optional;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BasicStudentDaoTest {

    private static Student studentTest;
    private StudentDaoService studentService = new BasicStudentDao();

    @BeforeAll
    static void setUp() {
        studentTest = new Student("student666", "student666@gmail.com");
    }

    @Test
    @Order(1)
    void testAddStudent_shouldReturn1() {
        studentService.add(studentTest);
        var students = studentService.findStudentsByName("student666");
        Assertions.assertEquals(1, students.size());
    }

    @Test
    @Order(2)
    void testFindStudentById_shouldReturnPresent() {
        Optional<Student> student = studentService.findById(studentTest.getId());
        Assertions.assertTrue(student.isPresent());
    }

    @Test
    @Order(3)
    void testUpdateStudent_byEmail() {

        Optional<Student> student = studentService.findById(studentTest.getId());
        studentTest.setEmail("123@gmail.com");
        if (student.isPresent()) {
            var dd = student.get();
            dd.setEmail("123@gmail.com");
            studentService.update(dd);
        }
        Assertions.assertEquals("123@gmail.com", studentTest.getEmail());
    }

    @Test
    @Order(4)
    void testDeleteStudentById_shouldReturn0() {
        Optional<Student> student = studentService.findById(studentTest.getId());
        if (student.isPresent()) {
            studentService.remove(studentTest.getId());
        }
        List<Student> students = studentService.findStudentsByName("student888");
        Assertions.assertEquals(0, students.size());
    }

    @Test
    void testFindAllStudents_shouldReturnNotNull() {
        List<Student> students = studentService.findAll();
        Assertions.assertNotNull(students);
    }
}
