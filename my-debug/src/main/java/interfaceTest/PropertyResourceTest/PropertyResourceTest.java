package interfaceTest.PropertyResourceTest;

import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.parsing.FailFastProblemReporter;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@PropertySource(value = "classpath:dbconfig.properties")
public class PropertyResourceTest {
	@Value("${jdbc.username}")
	private String userName;
	@Value("${jdbc.password}")
	private String password;

	public static void main(String[] args) throws IOException {
		/*AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PropertyResourceTest.class);
		PropertyResourceTest propertyResourceTest = applicationContext.getBean("propertyResourceTest", PropertyResourceTest.class);
		String password = propertyResourceTest.getPassword();
		System.out.println(password);*/
		PropertyResourceTest propertyResourceTest =new PropertyResourceTest();
		propertyResourceTest.test();
	}

	public void test() throws IOException {
		/**
		 * 将ComponentScanParserTest声明成一个BeanDefinition
		 */
		AnnotatedGenericBeanDefinition beanDefinition = new AnnotatedGenericBeanDefinition(PropertyResourceTest.class);
		AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(beanDefinition.getMetadata().getAnnotationAttributes(PropertySource.class.getName(), false));
		ConfigurationClassParser configurationClassParser = this.getConfigurationClassParser();
		configurationClassParser.processPropertySource(annotationAttributes);
	}

	public ConfigurationClassParser getConfigurationClassParser() {
		/**
		 * spring源码就是通过ComponentScan注解解析器解析@ComponentScan注解的。
		 */
		ConfigurationClassParser configurationClassParser = new ConfigurationClassParser(
				new CachingMetadataReaderFactory(),
				new FailFastProblemReporter(),
				new StandardEnvironment(),
				new DefaultResourceLoader(),
				new AnnotationBeanNameGenerator(),
				new DefaultListableBeanFactory()
		);
		return configurationClassParser;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
