package ccf.aop;

import org.springframework.stereotype.Component;

/**
 * 现在需要按照需求给UserService添加日志
 */
@Component
public class UserService {

	public String getUserName(){
		System.out.println("用户姓名[name:lisi]");
	   return "用户姓名[name:lisi]";
	}

	public String getUserAge(){
		return "用户年龄[age:22]";
	}

}
