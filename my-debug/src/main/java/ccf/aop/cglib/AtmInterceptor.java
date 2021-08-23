package ccf.aop.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class AtmInterceptor implements MethodInterceptor {
    /**
     * obj：cglib生成的代理对象
     * method：被代理对象方法
     * args：方法入参
     * methodProxy: 代理方法
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("事务开始");
        Object result = proxy.invokeSuper(obj, args);
        System.out.println(result);
        System.out.println("事务结束");
        return result;
    }


    public static void main(String[] args) {
        //class 文件缓存目录，如果不研究动态类的源码可以不设置
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/chenchaofan/IdeaProjects/lianpengju-master/cglib_classes");
        //用于创建代理对象的增强器，可以对目标对象进行扩展
        Enhancer enhancer = new Enhancer();
        //将目标对象设置为父类
        enhancer.setSuperclass(Atm.class);
        //设置目标拦截器
        enhancer.setCallback(new AtmInterceptor());
        // 创建代理对象
        Atm atm = (Atm)enhancer.create();
        // 通过代理对象调用目标方法
        Object result = atm.withdraw(100);
        atm.checkBalance();
    }

}

