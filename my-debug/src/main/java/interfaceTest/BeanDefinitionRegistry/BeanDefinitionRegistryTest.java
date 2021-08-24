package interfaceTest.BeanDefinitionRegistry;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.*;

public class BeanDefinitionRegistryTest {

	public static void main(String[] args) {
		/**
		 *DefaultListableBeanFactory 是BeanFactory的子类，同时也实现类BeanDefinitionRegistry接口
		 */
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		/**
		 * 注册Bean定义
		 */
		registerBeanDefinition(beanFactory);

		/**
		 *根据名称获取bean定义
		 */
		BeanDefinition userBeanDefinition = getBeanDefinition("user", beanFactory);


		User user = beanFactory.getBean("user", User.class);

		System.out.println(user);
	}

	/**
	 * 注册Bean定义
	 */
	public static void registerBeanDefinition(BeanDefinitionRegistry registry){
		RootBeanDefinition def = new RootBeanDefinition(User.class);
		def.setScope(ConfigurableBeanFactory.SCOPE_SINGLETON);
		//创建bean定义
		registry.registerBeanDefinition("user",def);
	}


	/**
	 * 根据名称删除bean定义
	 */
	void removeBeanDefinition(String beanName) {

	}

	/**
	 * 根据名称获取bean定义
	 */
	public static  BeanDefinition getBeanDefinition(String beanName,BeanDefinitionRegistry registry) {
		BeanDefinition beanDefinition = registry.getBeanDefinition(beanName);
		return beanDefinition;
	}

	/**
	 * 判断是否包含指定名称的Bean定义
	 */
	boolean containsBeanDefinition(String beanName){
		return true;
	}

	/**
	 * 获取所有已经注册的bean定义名称
	 */
	String[] getBeanDefinitionNames(){
		return null;
	}

	/**
	 * 获取注册过的bean定义数量
	 */
	int getBeanDefinitionCount(){
		return 0;
	}

	/**
	 *根据名称判断bean定义是否正在使用
	 */
	boolean isBeanNameInUse(String beanName){
		return true;
	}

}
