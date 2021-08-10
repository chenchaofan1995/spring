package ccf.transaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan({"ccf.transaction"})
@Configuration
public class TransactionApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TransactionApplication.class);
		IAdminService adminService = applicationContext.getBean("adminServiceImpl", IAdminService.class);
		adminService.updateBalance(1);

	}
}
