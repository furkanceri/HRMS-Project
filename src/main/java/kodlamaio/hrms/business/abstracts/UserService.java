package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.User;

import java.util.List;

public interface UserService {

    DataResult<List<User>> getAll();
}
