package ccf.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserAspect {
	@Pointcut(value="execution(* ccf.aop.UserService.*(..) )")
	public void myPointCut() {
	}

	@Before(value="myPointCut()")
	public void before() {
		System.out.println("前置通知");
	}

	@Around(value="myPointCut()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println("环绕通知开始");
		Object o = null;
		try {
			o = proceedingJoinPoint.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		System.out.println("环绕通知结束");
		return o;
	}

	@After(value ="myPointCut()")
	public void after() {
		System.out.println("后置通知");
	}

	@AfterReturning(value ="myPointCut()")
	public void afterReturing() {
		System.out.println("正常返回通知");
	}

	@AfterThrowing(value="myPointCut()")
	public void afterThrowing() {
		System.out.println("异常返回通知");
	}
}
