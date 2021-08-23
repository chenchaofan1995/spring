package ccf.factorymethod;

public class User {
    private String name;

    private String sex;

    private Car car;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }



    public User(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public User(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", car=" + car +
                '}';
    }
}
