package ccf.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AdminDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void updateBalance(long id){
		String sql = "update admin set blance=blance-1 where id=?";
		jdbcTemplate.update(sql,id);;
	}


	public void updateUsername(long id,String username){
		String sql = "update admin set username =? where id = ?";
		jdbcTemplate.update(username,id);
	}

}
