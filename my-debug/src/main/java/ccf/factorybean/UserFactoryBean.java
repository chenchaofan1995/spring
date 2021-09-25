package ccf.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.SmartFactoryBean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * SmartFactoryBean的父类就是FactoryBean
 */
@Component("user")
public class UserFactoryBean implements SmartFactoryBean<UserBean> {
    @Override
    public UserBean getObject() throws Exception {
        UserBean user = new UserBean();
        user.setName("李四");
        user.setAge(22);
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return UserBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

	@Override
	public boolean isEagerInit(){
    	return false;
	}
}
