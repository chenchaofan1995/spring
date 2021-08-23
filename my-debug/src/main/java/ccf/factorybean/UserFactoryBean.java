package ccf.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component("user")
public class UserFactoryBean implements FactoryBean<UserBean> {
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
}
