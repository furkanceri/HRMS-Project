package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployersService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.results.adapters.abstracts.CompanyStaffValidationService;
import kodlamaio.hrms.core.utilities.results.adapters.abstracts.EmailVerifyAndValidService;
import kodlamaio.hrms.dataAccess.abstracts.EmployersDao;
import kodlamaio.hrms.entities.concretes.Employers;

@Service
public class EmployersManager implements EmployersService {

	private EmployersDao employersDao;
	private EmailVerifyAndValidService emailVerifyAndValidService;
	private CompanyStaffValidationService companyStaffValidation;

	@Autowired
	public EmployersManager(EmployersDao employersDao, EmailVerifyAndValidService emailVerifyAndValidService) {
		super();
		this.employersDao = employersDao;
		this.emailVerifyAndValidService=emailVerifyAndValidService;
	}

	@Override
	public Result add(Employers employers) {
		if (employersDao.findByEmail(employers.getEmail())!=null || employersDao.findByWebSite(employers.getWebSite())!=null) {
			return new ErrorResult("Bu mail adresi ve şirket web-sitesi daha önce kayıt edilmiş");
		}
		if (checkEmailAndWebsite(employers)!=null) {
			return new ErrorResult("E-posta ve domain eşleşmiyor");
		}
		if (!emailVerifyAndValidService.emailVerify(employers.getEmail())) {
			return new ErrorResult("Geçersiz bir e-posta adresi girdiniz");
		}
		if (!emailVerifyAndValidService.emailValid(employers.getEmail())) {
			return new ErrorResult("Lütfen gönderilen doğrulama linkine tıklayınız");
		}
//		if (!companyStaffValidation.companyStaffValidation(employers, employers.getEmail())) {
//			return new ErrorResult("Hesabınız şirket personeli tarafından onaylanmamıştır");
//		}
		this.employersDao.save(employers);
		return new SuccessResult("İşveren başarıyla sisteme eklendi");
	}

	@Override
	public DataResult<List<Employers>> getAll() {
		return new SuccessDataResult<List<Employers>>(employersDao.findAll(), "İşverenler listenlendi");
	}
	private Result checkEmailAndWebsite(Employers employers) {
		String email=employers.getEmail();
		String website=employers.getWebSite();
		String[] emailSplit=email.split("@");
		String[] websiteSplit=website.split("www.");
		if (!emailSplit[1].equals(websiteSplit[1])) {
			return new ErrorResult("E-posta ile web-site domain adresi aynı olmalıdır");
		}return null;
	}
}
