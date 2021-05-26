package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Users;

public interface UsersService {

	DataResult<List<Users>> getAll();
	Result add(Users users);
	DataResult<Users> getByEmail(String email);
}
