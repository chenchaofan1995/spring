package ccf.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.StandardEnvironment;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"ccf.aop"})
public class AopApplication {
    public static void main(String[] args) throws NoSuchMethodException {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true"); //设置系统属性

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopApplication.class);
       /* StandardEnvironment standardEnvironment = new StandardEnvironment();

        applicationContext.setEnvironment(standardEnvironment);*/
        MyCalculator myCalculator = (MyCalculator)applicationContext.getBean("myCalculator");
        myCalculator.add(1,2);
    }
}
