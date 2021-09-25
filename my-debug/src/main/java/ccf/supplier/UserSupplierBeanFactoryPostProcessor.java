package ccf.supplier;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class UserSupplierBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        GenericBeanDefinition userSupplierBeanDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition("user");
        userSupplierBeanDefinition.setInstanceSupplier(() -> {
            User user = new User();
            user.setName("lisi");
            return user;
        });
        userSupplierBeanDefinition.setBeanClass(User.class);
    }
}
