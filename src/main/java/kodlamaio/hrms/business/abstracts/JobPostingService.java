package kodlamaio.hrms.business.abstracts;



import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;

public interface JobPostingService {

	Result add(JobPosting jobPosting);
	Result update(JobPosting jobPosting);
	Result delete(int id);
	DataResult<List<JobPosting>> getByisActiveJobPostings();
	DataResult<List<JobPosting>> getByisActiveAndEmployers_companyName(String companyName);
	//DataResult<List<JobPosting>> getByisActiveTrueOrderBydeclarationDate();
	DataResult<JobPosting> getById(int id);
}
