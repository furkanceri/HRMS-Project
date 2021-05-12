package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployersService;
import kodlamaio.hrms.dataAccess.abstracts.EmployersDao;
import kodlamaio.hrms.entities.concretes.Employers;


@Service
public class EmployersManager implements EmployersService{

	private EmployersDao employersDao;
	
	@Autowired// 2. kullanım yöntemi
	public EmployersManager(EmployersDao employersDao) {
		super();
		this.employersDao = employersDao;
	}

	@Override
	public List<Employers> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
