package ccf.initDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Configuration
public class InitDestroyApplication {

	@Resource(name = "user1")
	private User user1;

	@Autowired
	private User user2;


	public InitDestroyApplication() {
		System.out.println("InitDestroyApplication 构造函数");
	}


	@PostConstruct
	public void init(){
		System.out.println("InitDestroyApplication 对象初始化");
	}

	@PreDestroy
	public void destroy(){
		System.out.println("InitDestroyApplication 对象销毁");
	}


	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext =  new AnnotationConfigApplicationContext(InitDestroyApplication.class);
		InitDestroyApplication initDestroyApplication = applicationContext.getBean("initDestroyApplication", InitDestroyApplication.class);
		User user1 = initDestroyApplication.getUser1();
		User user2 = initDestroyApplication.getUser2();
		System.out.println("====");

	}

	@Bean(name = "user1")
	public User user1(){
		User user1 = new User();
		user1.setUserName("user1");
		return user1;
	}

	@Bean(name = "user2")
	public User user2(){
		User user2 = new User();
		user2.setUserName("user2");
		return user2;
	}

	public User getUser1() {
		return user1;
	}

	public User getUser2() {
		return user2;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}
}
