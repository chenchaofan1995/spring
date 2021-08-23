package ccf.instantiationAwareBeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class UserInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("beanName:" + beanName + "----执行postProcessBeforeInstantiation方法");

        if (UserInstantiation.class == beanClass) {

            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(beanClass);
            enhancer.setCallback(new MethodInterceptor() {
                /**
                 *
                 * @param o 代理对象
                 * @param method  被代理方法（被拦截到的方法）
                 * @param objects 方法参数
                 * @param methodProxy 代理方法
                 * @return
                 * @throws Throwable
                 */
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    System.out.println("目标方法执行之前：" + method);
                    //执行被拦截到的method方法
                    Object o1 = methodProxy.invokeSuper(o, objects);
                    System.out.println("目标方法执行之后：" + method);
                    return o1;
                }
            });
            UserInstantiation userInstantiation = (UserInstantiation) enhancer.create();
            userInstantiation.setName("李四");
            return userInstantiation;
        }
        return null;
    }
}
