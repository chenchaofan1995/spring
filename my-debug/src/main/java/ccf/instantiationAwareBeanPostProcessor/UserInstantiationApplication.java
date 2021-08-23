package ccf.instantiationAwareBeanPostProcessor;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"ccf.instantiationAwareBeanPostProcessor"})
public class UserInstantiationApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(UserInstantiationApplication.class);
        UserInstantiation userInstantiation = (UserInstantiation) applicationContext.getBean("userInstantiation");
        System.out.println(userInstantiation);
    }

}
