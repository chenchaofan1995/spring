package ccf.importtest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(value ={MyImportBeanDefinitionRegistrar.class})
//@Import(value ={MyImportSelector.class})
//@Import(value ={MyDeferredImportSelector.class})
@Configuration
public class ImportTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImportTest.class);

    }
}
