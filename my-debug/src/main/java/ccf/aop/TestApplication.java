package ccf.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan({"ccf.aop"})
@Configuration
@EnableAspectJAutoProxy
public class TestApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestApplication.class);
		UserService userService = (UserService) applicationContext.getBean("userService");
		userService.getUserName();
	}
}
