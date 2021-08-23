package ccf.factorymethod;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"ccf.factorymethod"})
public class FactoryMethodApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(FactoryMethodApplication.class);
        User user1 = (User) applicationContext.getBean("user1");
        System.out.println(user1);
    }
}
