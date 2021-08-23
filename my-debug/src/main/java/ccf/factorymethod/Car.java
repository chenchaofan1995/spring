package ccf.factorymethod;

import org.springframework.stereotype.Component;

@Component
public class Car {

    private  String name;

    public Car() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
