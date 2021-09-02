package ccf.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanTest.class);

		User user = applicationContext.getBean("user", User.class);
		System.out.println(user);
	}


	@Bean
	public User user(){
		User user = new User();
		user.setUserName("lisi");
		user.setAge(22);
		return user;
	}
}
