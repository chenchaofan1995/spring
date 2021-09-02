package ccf.condition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Map;

@ComponentScan("ccf.condition")
public class ConditionalTest {


	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConditionalTest.class);

		Person bean = applicationContext.getBean("",Person.class);
		System.out.println(bean);
	}

}
