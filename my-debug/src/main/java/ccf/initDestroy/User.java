package ccf.initDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

public class User  implements InitializingBean, DisposableBean {
	private String userName;

	private Integer age;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User{" +
				"userName='" + userName + '\'' +
				", age=" + age +
				'}';
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean 销毁");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean 初始化");
	}
}
