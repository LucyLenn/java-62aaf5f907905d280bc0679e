package ua.hillel.homeworks.homework31.persistent;

import lombok.SneakyThrows;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import ua.hillel.homeworks.homework31.persistent.entity.Student;

public class HibernateSession {

    private static final SessionFactory sessionFactory = buildSessionFactory();

      public static SessionFactory getSessionFactory() {
           return sessionFactory;
    }

    @SneakyThrows
    public static SessionFactory buildSessionFactory() {
        ServiceRegistry serviceRegistry = configureServiceRegistry();
        return makeSessionFactory(serviceRegistry);
    }

    private static ServiceRegistry configureServiceRegistry(){
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

        registryBuilder.applySetting("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        registryBuilder.applySetting("hibernate.connection.driver_class", "org.postgresql.Driver");
        registryBuilder.applySetting("hibernate.show_sql", "true");
        registryBuilder.applySetting("hibernate.connection.url", "jdbc:postgresql://localhost:5432/homework31");
        registryBuilder.applySetting("hibernate.connection.username", "postgres");
        registryBuilder.applySetting("hibernate.connection.password", "password");
        registryBuilder.applySetting("hibernate.hbm2ddl.auto", "none");
        registryBuilder.applySetting("hibernate.current_session_context_class", "thread");

        return registryBuilder.build();
    }

    private static SessionFactory makeSessionFactory(ServiceRegistry serviceRegistry) {
        MetadataSources metadataSources = new MetadataSources(serviceRegistry);

        metadataSources.addAnnotatedClass(Student.class);
        Metadata metadata = metadataSources.getMetadataBuilder()
                .build();

        return metadata.getSessionFactoryBuilder()
                .build();
    }
}
