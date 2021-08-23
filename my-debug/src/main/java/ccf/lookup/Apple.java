package ccf.lookup;

import org.springframework.stereotype.Component;

@Component
public class Apple {
    private String name ="苹果";

    public Apple() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                "hashCode='" + this.hashCode() + '\'' +
                '}';
    }
}
