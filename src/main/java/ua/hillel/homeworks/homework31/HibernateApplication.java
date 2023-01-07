package ua.hillel.homeworks.homework31;

import ua.hillel.homeworks.homework31.persistent.dao.BasicStudentDao;
import ua.hillel.homeworks.homework31.persistent.entity.Student;
import ua.hillel.homeworks.homework31.persistent.service.StudentDaoService;

import java.util.List;

public class HibernateApplication {

    public static void main(String[] args) {
        StudentDaoService studentService = new BasicStudentDao();

        List<Student> students = studentService.findAll();
        students.forEach(System.out::println);
    }
}
