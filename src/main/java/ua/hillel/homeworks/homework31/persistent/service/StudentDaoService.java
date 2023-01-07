package ua.hillel.homeworks.homework31.persistent.service;

import ua.hillel.homeworks.homework31.persistent.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDaoService {
    Optional<Student> findById(long id);

    List<Student> findAll();

    void add(Student student);

    void remove(long id);

    void update(Student student);

    List<Student> findStudentsByName(String name);
}
