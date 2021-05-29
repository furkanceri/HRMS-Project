package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService{

	private JobPostingDao jobPostingDao;
	
	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public Result add(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("İş ilanı başarıyla eklendi");
	}

	@Override
	public Result update(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("İş ilanı başarıyla güncellendi");
	}

	@Override
	public Result delete(int id) {
		if (getById(id).getData().isActive()) {
			return new ErrorResult("İş ilanı kaldırılamadı");
		}
		this.jobPostingDao.deleteById(id);
		return new SuccessResult("İş ilanı kaldırıldı");
	}

	@Override
	public DataResult<List<JobPosting>> getByisActiveJobPostings() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByisActiveTrue(), "Kullanımda olan tüm ilanlar");
	}

	@Override
	public DataResult<List<JobPosting>> getByisActiveAndEmployers_companyName(String companyName) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByisActiveTrueAndEmployers_companyName(companyName), "İlan şirket bilgileri");
	}

//	@Override
//	public DataResult<List<JobPosting>> getByisActiveTrueOrderBydeclarationDate() {
//		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByIsActiveTrueOrderBydeclarationDate(), "İlan tarihleri");
//	}

	@Override
	public DataResult<JobPosting> getById(int id) {
		
		return new SuccessDataResult<JobPosting>(this.jobPostingDao.getOne(id));
	}

}
