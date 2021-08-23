package ccf.instantiationAwareBeanPostProcessor;

import org.springframework.stereotype.Component;

@Component
public class UserInstantiation {

    private String name;

    public UserInstantiation() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserInstantiation{" +
                "name='" + name + '\'' +
                '}';
    }
}
