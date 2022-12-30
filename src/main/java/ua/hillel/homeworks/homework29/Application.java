package ua.hillel.homeworks.homework29;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.hillel.homeworks.homework29.dataaccess.DataSourceConfiguration;
import ua.hillel.homeworks.homework29.dataaccess.dao.CartDaoBasic;
import ua.hillel.homeworks.homework29.dataaccess.dao.ProductDaoBasic;

public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);

        CartDaoBasic cartDaoBasic = context.getBean(CartDaoBasic.class);
        ProductDaoBasic productDaoBasic = context.getBean(ProductDaoBasic.class);
    }
}
