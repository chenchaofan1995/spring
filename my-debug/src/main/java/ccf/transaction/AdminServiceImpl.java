package ccf.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AdminServiceImpl implements IAdminService{
	@Autowired
	private AdminDao adminDao;

	@Override
	@Transactional(rollbackFor ={Exception.class} )
	public void updateBalance(long id) {
		adminDao.updateBalance(id);
	}

	@Override
	@Transactional(rollbackFor ={Exception.class} )
	public void updateUsername(long id, String username) {
		adminDao.updateUsername(id,username);
	}
}
