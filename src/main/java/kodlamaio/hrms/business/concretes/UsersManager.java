package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UsersService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UsersDao;
import kodlamaio.hrms.entities.concretes.Users;


@Service
public class UsersManager implements UsersService{

	
	private UsersDao usersDao;
	
	@Autowired
	public UsersManager(UsersDao usersDao) {
		super();
		this.usersDao = usersDao;
	}

	@Override
	public DataResult<List<Users>> getAll() {
		return new SuccessDataResult<List<Users>>(this.usersDao.findAll(), "All users listed");
		
		//return new ErrorDataResult<List<Users>>("Users could not be listed");
	}

	@Override
	public Result add(Users users) {
		this.usersDao.save(users);
		return new SuccessResult("New user added successfully");
	}

	@Override
	public DataResult<Users> getByEmail(String email) {
		return new SuccessDataResult<Users>(usersDao.findByEmail(email));
	}


}
