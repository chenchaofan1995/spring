package ccf.factorybean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"ccf.factorybean"})
public class TestApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestApplication.class);
        UserBean user = applicationContext.getBean("user", UserBean.class);
        System.out.println(user);
    }
}
