package interfaceTest.ComponentScanParser;

import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;
import java.util.Set;

@ComponentScan("interfaceTest.ComponentScanParser")
public class ComponentScanParserTest {

	public static void main(String[] args) {
		ComponentScanParserTest componentScanParserTest = new ComponentScanParserTest();
		componentScanParserTest.parse();
	}

	public void parse() {
		/**
		 * 将ComponentScanParserTest声明成一个BeanDefinition
		 */
		AnnotatedGenericBeanDefinition beanDefinition = new AnnotatedGenericBeanDefinition(ComponentScanParserTest.class);

		/**
		 * 获取@ComponentScan注解解析器
		 */
		ComponentScanAnnotationParser componentScanAnnotationParser = this.getComponentScanAnnotationParser();

		/**
		 * 获取类上的注解属性值
		 */
		AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(beanDefinition.getMetadata().getAnnotationAttributes(ComponentScan.class.getName(), false));

		/**
		 * 根据注解属性值将包下的bean转换成BeanDifiniton
		 */
		Set<BeanDefinitionHolder> beanDefinitionHolders = componentScanAnnotationParser.parse(annotationAttributes, ComponentScanParserTest.class.getName());

		System.out.println(beanDefinitionHolders);


	}

	/**
	 * 获取ComponentScan注解解析器
	 *
	 * @return ComponentScanAnnotationParser：ComponentScan注解解析器
	 */
	public ComponentScanAnnotationParser getComponentScanAnnotationParser() {
		/**
		 * spring源码就是通过ComponentScan注解解析器解析@ComponentScan注解的。
		 */
		ComponentScanAnnotationParser componentScanAnnotationParser = new ComponentScanAnnotationParser(
				new StandardEnvironment(),
				new DefaultResourceLoader(),
				new AnnotationBeanNameGenerator(),
				new DefaultListableBeanFactory()
		);
		return componentScanAnnotationParser;
	}

}
