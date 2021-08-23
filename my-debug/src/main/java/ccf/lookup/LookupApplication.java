package ccf.lookup;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 测试@looup 注解
 */
@Configuration
@ComponentScan({"ccf.lookup"})
public class LookupApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(LookupApplication.class);
        Apple apple1 = (Apple) applicationContext.getBean("apple");
        System.out.println("apple1="+apple1);

        Apple apple2 = (Apple) applicationContext.getBean("apple");
        System.out.println("apple2="+apple2);


        BananaLookup bananaLookup1 = (BananaLookup)applicationContext.getBean("bananaLookup");
        Banana banana1 = bananaLookup1.getBanana();
        System.out.println("banana1="+banana1);

        Banana banana2 = bananaLookup1.getBanana();

        System.out.println("banana2="+banana2);



    }

}
