package ccf.propertySource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource(value = {"classpath:dbconfig.properties"})
@Component
public class PropertySourceApplication {

	@Value("${jdbc.username}")
	private String name;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PropertySourceApplication.class);
		PropertySourceApplication propertySourceApplication = applicationContext.getBean("propertySourceApplication",PropertySourceApplication.class);
		String name = propertySourceApplication.getName();
		System.out.println("name="+name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
