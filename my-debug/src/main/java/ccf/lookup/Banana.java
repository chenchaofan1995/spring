package ccf.lookup;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Banana {

    private String name = "香蕉";

    public Banana() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Banana{" +
                "name='" + name + '\'' +
                "hashCode='" + this.hashCode() + '\'' +
                '}';
    }
}
