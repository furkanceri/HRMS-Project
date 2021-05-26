package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekersService;
import kodlamaio.hrms.business.abstracts.UsersService;
import kodlamaio.hrms.core.adapters.abstracts.FakeMernisService;
import kodlamaio.hrms.core.adapters.abstracts.isEmailValid;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekersDao;
import kodlamaio.hrms.entities.concretes.JobSeekers;

@Service
public class JobSeekersManager implements JobSeekersService {

	private JobSeekersDao jobSeekersDao;
	private UsersService usersService;
	private FakeMernisService fakeMernisService;
	private isEmailValid isEmailValid;

	@Autowired
	public JobSeekersManager(JobSeekersDao jobSeekersDao, UsersService usersService,
			FakeMernisService fakeMernisService,isEmailValid isEmailValid) {
		super();
		this.jobSeekersDao = jobSeekersDao;
		this.usersService = usersService;
		this.fakeMernisService = fakeMernisService;
		this.isEmailValid=isEmailValid;

	}

	@Override
	public DataResult<List<JobSeekers>> getAll() {

		return new SuccessDataResult<List<JobSeekers>>(this.jobSeekersDao.findAll(), "Job seekers listed");

		// return new ErrorDataResult<List<JobSeekers>>("Job seekers could not be listed");
	}

	@Override
	public Result add(JobSeekers jobSeekers) {

		if (registerRules(jobSeekers) != null)
			return registerRules(jobSeekers);

		if (!isEmailValid.isEmailValidation(jobSeekers.getEmail())) {
			return new ErrorResult("Please enter a valid email format");
		}
		if (!isEmailValid.isEmailValidationOnClick(jobSeekers.getEmail())) {
			return new ErrorResult("Please confirm your email address from the activation link sent to your email address");
		}
		if (!fakeMernisService.validate(jobSeekers.getNationalityId(), jobSeekers.getFirstName(),
				jobSeekers.getLastName(), jobSeekers.getBirthYear())) {
			return new ErrorResult("Credentials could not be verified. Please enter valid credentials");
		}
		else {
		this.jobSeekersDao.save(jobSeekers);
		return new SuccessResult("New job seeker added successfully");}
	}

	private Result registerRules(JobSeekers jobSeekers) {

		if (isAllFieldsFilled(jobSeekers) != null) {
			return isAllFieldsFilled(jobSeekers);
		}
		if (emailControl(jobSeekers) != null) {
			return emailControl(jobSeekers);
		}
		if (nationalityIdControl(jobSeekers) != null) {
			return nationalityIdControl(jobSeekers);
		}
		return null;
	}

	private Result isAllFieldsFilled(JobSeekers jobSeekers) {
		if (jobSeekers.getFirstName() == null || jobSeekers.getLastName() == null || jobSeekers.getEmail() == null
				|| jobSeekers.getPassword() == null || jobSeekers.getBirthYear() == null
				|| jobSeekers.getNationalityId() == null) {
			return new ErrorResult("All fields must be filled");
		}
		return null;
	}

	private Result emailControl(JobSeekers jobSeekers) {
		if (usersService.getByEmail(jobSeekers.getEmail()).getData() != null) {
			return new ErrorResult("This email address is already in use");
		}
		return null;
	}

	private Result nationalityIdControl(JobSeekers jobSeekers) {
		if (jobSeekersDao.findByNationalityId(jobSeekers.getNationalityId()) != null) {
			return new ErrorResult("This identity number is already in use");
		}
		return null;
	}

}
