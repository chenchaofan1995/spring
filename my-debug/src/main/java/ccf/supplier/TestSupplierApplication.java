package ccf.supplier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ccf.supplier")
public class TestSupplierApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(TestSupplierApplication.class);
        UserSupplier userSupplier = (UserSupplier)annotationConfigApplicationContext.getBean("userSupplier");
        System.out.println(userSupplier);
    }
}
