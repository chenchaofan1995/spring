package ccf.importtest;



public class City   {
	private String name;

	private String address;

	public City() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "City{" +
				"name='" + name + '\'' +
				'}';
	}

	public void init(){
		System.out.println("city 执行初始化");
	}

	public void destroy(){
		System.out.println("city 执行销毁");
	}

}
