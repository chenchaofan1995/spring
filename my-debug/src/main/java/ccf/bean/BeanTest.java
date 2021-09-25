package ccf.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanTest {

	@Autowired
	private User user;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanTest.class);

		//User user = applicationContext.getBean("user", User.class);
		BeanTest beanTest = applicationContext.getBean("beanTest", BeanTest.class);

		System.out.println(beanTest.getUser());
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Bean
	public User user(){
		User user = new User();
		user.setUserName("lisi");
		user.setAge(22);
		return user;
	}
}
