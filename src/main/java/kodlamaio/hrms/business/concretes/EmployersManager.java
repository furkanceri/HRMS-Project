package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployersService;
import kodlamaio.hrms.business.abstracts.UsersService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployersDao;
import kodlamaio.hrms.entities.concretes.Employers;
import kodlamaio.hrms.entities.concretes.Users;
import net.bytebuddy.asm.Advice.This;

@Service
public class EmployersManager implements EmployersService {

	private EmployersDao employersDao;
	private UsersService usersService;

	@Autowired
	public EmployersManager(EmployersDao employersDao, UsersService usersService) {
		super();
		this.employersDao = employersDao;
		this.usersService = usersService;
	}

	@Override
	public DataResult<List<Employers>> getAll() {

		return new SuccessDataResult<List<Employers>>(this.employersDao.findAll(), "Employers listed");

		// return new ErrorDataResult<List<Employers>>("Employers could not be listed");
	}

	@Override
	public Result add(Employers employers) {

		if (companyRegisterRules(employers) != null) {
			return companyRegisterRules(employers);
		}
		this.employersDao.save(employers);
		return new SuccessResult("New employers added successfully");
	}

	private Result companyRegisterRules(Employers employers) {
		if (isAllFieldsFilled(employers) != null) {
			return isAllFieldsFilled(employers);
		}
		if (webSiteEmailControl(employers) != null) {
			return webSiteEmailControl(employers);
		}
		if (emailControl(employers) != null) {
			return emailControl(employers);
		}
		return null;
	}

	private Result isAllFieldsFilled(Employers employers) {
		if (employers.getCompanyName() == null || employers.getCompanyPhoneNumber() == null
				|| employers.getCompanyWebSite() == null || employers.getEmail() == null
				|| employers.getPassword() == null) {
			return new ErrorResult("All fields must be filled");
		}
		if (employers.getCompanyName().equals("") || employers.getCompanyPhoneNumber().equals("")
				|| employers.getCompanyWebSite().equals("") || employers.getEmail().equals("")
				|| employers.getPassword().equals("")) {
			return new ErrorResult("All fields must be filled");
		}
		return null;
	}

	private Result webSiteEmailControl(Employers employers) {
		String email = employers.getEmail();
		String[] emailSplit = email.split("@");
		if(!emailSplit[1].equals(employers.getCompanyWebSite())) 
			{return new ErrorResult("Company website and e-mail address are not the same");}
		return null;
	}

	private Result emailControl(Employers employers) {
		if (usersService.getByEmail(employers.getEmail()).getData() != null) {
			return new ErrorResult("This email address is already in use");
		}
		return null;
	}

}
