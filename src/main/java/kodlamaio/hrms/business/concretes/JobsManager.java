package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobsService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobsDao;
import kodlamaio.hrms.entities.concretes.Jobs;
import net.bytebuddy.asm.Advice.This;


@Service
public class JobsManager implements JobsService{

	
	private JobsDao jobsDao;
	
	@Autowired
	public JobsManager(JobsDao jobsDao) {
		super();
		this.jobsDao = jobsDao;
	}


	@Override
	public DataResult<List<Jobs>> getAll() {		
		return new SuccessDataResult<List<Jobs>>(this.jobsDao.findAll(), "Jobs listed");
		
		//return new ErrorDataResult<List<Jobs>>("Jobs could not be listed");
	}


	@Override
	public Result add(Jobs jobs) {
		if(jobsRegisterRules(jobs)!= null) return jobsRegisterRules(jobs);
		this.jobsDao.save(jobs);
		return new SuccessResult("New job added");
	}

	
	private Result jobsRegisterRules(Jobs jobs) {
		if(isAllFieldsFilled(jobs)!=null) return isAllFieldsFilled(jobs);
		if(jobsNameControl(jobs)!=null) return jobsNameControl(jobs);
		return null;
	}
	private Result isAllFieldsFilled(Jobs jobs) {
		if(jobs.getJobs()==null) return new ErrorResult("All fields must be filled");
		return null;
	}
	private Result jobsNameControl(Jobs jobs) {
		if(jobsDao.findByJobs(jobs.getJobs())!=null)
			return new ErrorResult("This job name is already registered");
		return null;
	}
	

}
