package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekers;
import kodlamaio.hrms.entities.concretes.Users;

public interface JobSeekersService {

	DataResult<List<JobSeekers>> getAll();
	Result add(JobSeekers jobSeekers);
}
