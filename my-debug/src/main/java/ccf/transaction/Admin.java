package ccf.transaction;

import java.math.BigDecimal;

public class Admin {
	private Long id;
	private String username;
	private String pwd;
	private BigDecimal blance;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public BigDecimal getBlance() {
		return blance;
	}

	public void setBlance(BigDecimal blance) {
		this.blance = blance;
	}

	@Override
	public String toString() {
		return "Admin{" +
				"id=" + id +
				", username='" + username + '\'' +
				", pwd='" + pwd + '\'' +
				", blance=" + blance +
				'}';
	}
}
