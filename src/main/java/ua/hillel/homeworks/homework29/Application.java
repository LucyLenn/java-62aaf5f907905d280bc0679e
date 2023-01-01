package ua.hillel.homeworks.homework29;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.hillel.homeworks.homework29.dataaccess.DataSourceConfiguration;
import ua.hillel.homeworks.homework29.dataaccess.dao.BasicCartDao;
import ua.hillel.homeworks.homework29.dataaccess.dao.BasicProductDao;

public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);

        BasicCartDao cartDaoBasic = context.getBean(BasicCartDao.class);
        BasicProductDao productDaoBasic = context.getBean(BasicProductDao.class);
    }
}
