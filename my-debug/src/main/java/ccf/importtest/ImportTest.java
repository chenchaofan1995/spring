package ccf.importtest;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(value = {MyImportBeanDefinitionRegistrar.class})
//@Import(value ={MyImportSelector.class})
//@Import(value ={MyDeferredImportSelector.class})
@Configuration
public class ImportTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImportTest.class);
	}

	@Bean(initMethod = "init",destroyMethod = "destroy")
	public City city() {
		City city = new City();
		city.setName("贵阳");
		return city;
	}

	@Bean
	public User user(City city) {
		User user = new User();
		user.setName("lisi");
		user.setCity(city);
		return user;
	}
}
