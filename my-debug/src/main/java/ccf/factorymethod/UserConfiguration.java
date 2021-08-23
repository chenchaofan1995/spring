package ccf.factorymethod;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    public User user1(){
        User user = new User("lisi","男");
        return user;
    }

    @Bean
    public User user(Car car){
        User user = new User(car);
        return user;

    }


}
