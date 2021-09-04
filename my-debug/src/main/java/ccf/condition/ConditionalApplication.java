package ccf.condition;

import org.springframework.context.annotation.*;


/**
 * 1：@Conditional是做什么的?
 *
 * 2：@Conditional多个条件是什么逻辑关系？
 *
 * 3：条件判断在什么时候执行？
 *
 * 4：ConfigurationCondition和Condition有什么区别？什么时候使用ConfigurationCondition？
 *
 * 5：多个Condition执行的顺序是什么样的？可以配置优先级么？
 * 		自定义的Condition可以实现PriorityOrdered接口或者继承Ordered接口，或者使用@Order注解，通过这些来指定这些Condition的优先级。
 * 		排序规则：先按PriorityOrdered排序，然后按照order的值进行升序排序（值越小越先执行）。；也就是：PriorityOrdered asc,order值 asc
 *
 * 6：可以介绍一下@Conditional常见的一些用法么？

 org.springframework.context.annotation.ConfigurationClassUtils#isConfigurationCandidate
 */
@ComponentScan("ccf.condition")
@Configuration
public class ConditionalApplication {


	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConditionalApplication.class);

		Person bean = applicationContext.getBean("", Person.class);
		System.out.println(bean);
	}


	//只有一个类时，大括号可以省略
	//如果WindowsCondition的实现方法返回true，则注入这个bean
	@Conditional({WindowsCondition.class})
	@Bean(name = "bill")
	public Person person1() {
		return new Person("Bill Gates", 62);
	}

	//如果LinuxCondition的实现方法返回true，则注入这个bean
	@Conditional({LinuxCondition.class})
	@Bean("linus")
	public Person person2() {
		return new Person("Linus", 48);
	}
}
