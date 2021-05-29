package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekersService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.results.adapters.abstracts.EmailVerifyAndValidService;
import kodlamaio.hrms.core.utilities.results.adapters.concretes.FakeMernisManager;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekersDao;
import kodlamaio.hrms.entities.concretes.JobSeekers;

@Service
public class JobSeekersManager implements JobSeekersService {

	private JobSeekersDao jobSeekersDao;
	private FakeMernisManager fakeMernisService;
	private EmailVerifyAndValidService emailVerifyAndValidService;

	@Autowired
	public JobSeekersManager(JobSeekersDao jobSeekersDao, FakeMernisManager fakeMernisService, EmailVerifyAndValidService emailVerifyAndValidService) {
		super();
		this.jobSeekersDao = jobSeekersDao;
		this.emailVerifyAndValidService=emailVerifyAndValidService;
		this.fakeMernisService=fakeMernisService;
	}

	@Override
	public Result add(JobSeekers jobSeekers) {
		if (jobSeekersDao.findByEmail(jobSeekers.getEmail())!=null || jobSeekersDao.findByNationalityId(jobSeekers.getNationalityId())!=null) {
			return new ErrorResult("Bu eposta veya kimlik numarası daha önce sisteme kayıt edilmiş.");
		}
		if (jobSeekers.getBirthYear().isEmpty() && jobSeekers.getEmail().isEmpty() && jobSeekers.getFirstName().isEmpty()
				&& jobSeekers.getLastName().isEmpty() && jobSeekers.getNationalityId().isEmpty() && jobSeekers.getPassword().isEmpty()
				) {
			return new ErrorResult("Tüm alanlar doldurulmalıdır.");
		}
		if (!emailVerifyAndValidService.emailVerify(jobSeekers.getEmail())) {
			return new ErrorResult("Eposta adresi geçersiz");
		}
		if (!emailVerifyAndValidService.emailValid(jobSeekers.getEmail())) {
			return new ErrorResult("Lütfen gönderilen doğrulama linkine tıklayınız");
		}
//		if (!fakeMernisService.fakeMernisVerify(Long.parseLong(jobSeekers.getNationalityId()), jobSeekers.getFirstName().toUpperCase(), jobSeekers.getLastName().toUpperCase(), Integer.parseInt(jobSeekers.getBirthYear()))) {
//			return new ErrorResult("Mernis kimlik doğrulaması başarısız.");
//		}
		this.jobSeekersDao.save(jobSeekers);
		return new SuccessResult("İş arayan kullanıcı başarıyla eklendi");
	}

	@Override
	public DataResult<List<JobSeekers>> getAll() {
		return new SuccessDataResult<List<JobSeekers>>(this.jobSeekersDao.findAll()," İş arayanlar listelendi");
	}

	
	

}
