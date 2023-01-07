package ua.hillel.homeworks.homework31.persistent.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.hillel.homeworks.homework31.persistent.HibernateSession;
import ua.hillel.homeworks.homework31.persistent.entity.Student;
import ua.hillel.homeworks.homework31.persistent.service.StudentDaoService;

import java.util.List;
import java.util.Optional;

public class BasicStudentDao implements StudentDaoService {

    private final SessionFactory sessionFactory;

    public BasicStudentDao() {
        this.sessionFactory = HibernateSession.getSessionFactory();
    }

    @Override
    public Optional<Student> findById(long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.getTransaction().commit();

            return Optional.ofNullable(student);
        }
    }

    @Override
    public void add(Student student) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Student student) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public void remove(long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.remove(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Student> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createNativeQuery("SELECT id, name, email FROM student", Student.class).list();
        }
    }

    public List<Student> findStudentsByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            var students = session.createNativeQuery("SELECT id, name, email FROM student WHERE name LIKE :name", Student.class);
            students.setParameter("name", "%" + name + "%");

            return students.list();
        }
    }
}
