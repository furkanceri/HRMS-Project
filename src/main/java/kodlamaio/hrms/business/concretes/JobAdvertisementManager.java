package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisements) {
		if (jobAdvertisements.getJobDetail()==null && jobAdvertisements.getOpenPosition()==0 && 
				jobAdvertisements.getApplicationDeadline()==null && jobAdvertisements.getCities()==null) {
			return new ErrorResult("Alanlar boş bırakılamaz");
		}
		
		this.jobAdvertisementDao.save(jobAdvertisements);
		return new SuccessResult("İş ilanı eklendi");
	}
	

	@Override
	public Result delete(int id) {
		if (!getById(id).getData().isActive()) {
			return new ErrorResult("İş ilanı silinemedi");
		}
		this.jobAdvertisementDao.deleteById(id);
		return new SuccessResult("İş ilanı silindi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByisActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByisActiveTrue(), "Aktif iş ilanları listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByisActiveTrueAndEmployers_CompanyName(String companyName) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByisActiveTrueAndEmployers_CompanyName(companyName),"Firmaya göre iş ilanları listelendi");
	}

	
	@Override
	public DataResult<List<JobAdvertisement>> getByisActiveTrueOrderByReleaseDate() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByisActiveTrueOrderByReleaseDate(), "İlan sırasına göre listelendi");
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		return new SuccessDataResult<JobAdvertisement>(jobAdvertisementDao.getOne(id));
	}

}
