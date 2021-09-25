package ccf.factorybean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * FactoryBean测试用列。
 * 对于通过FactoryBean方式来创建的bean，Spring系统内部是先创建FactoryBean对象，
 * 然后等待用户调用getBean接口或者Spring系统未某个对象自动注入该对象时，
 * 才会去调用FactoryBean对象的getObject()接口来创建对象，
 */
@Configuration
@ComponentScan({"ccf.factorybean"})
public class TestApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestApplication.class);
        UserBean user = applicationContext.getBean("user", UserBean.class);
        System.out.println(user);
    }
}
