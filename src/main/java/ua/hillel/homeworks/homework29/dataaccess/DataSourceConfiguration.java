package ua.hillel.homeworks.homework29.dataaccess;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public class DataSourceConfiguration {

    @Bean
    public DataSource postgresDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5432/homework29");
        ds.setUsername("postgres");
        ds.setPassword("password");

        return ds;
    }
}
