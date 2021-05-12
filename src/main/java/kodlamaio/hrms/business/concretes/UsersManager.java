package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UsersService;
import kodlamaio.hrms.dataAccess.abstracts.UsersDao;
import kodlamaio.hrms.entities.concretes.Users;


@Service
public class UsersManager implements UsersService{

	@Autowired
	private UsersDao usersDao;
	
	@Override
	public List<Users> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
