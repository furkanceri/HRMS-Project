package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.adapters.abstracts.CompanyStaffValidationService;
import kodlamaio.hrms.core.utilities.adapters.abstracts.EmailValidationService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private EmailValidationService emailValidationService;
    private CompanyStaffValidationService companyStaffValidationService;
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, EmailValidationService emailValidationService, CompanyStaffValidationService companyStaffValidationService, JobAdvertisementService jobAdvertisementService) {
        this.employerDao = employerDao;
        this.emailValidationService = emailValidationService;
        this.companyStaffValidationService = companyStaffValidationService;
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @Override
    public Result add(Employer employer) {
        if (this.employerDao.findByEmail(employer.getEmail())!=null){
            return new ErrorResult("Bu şirket daha önce sisteme kayıt edilmiş. Lütfen e-posta ve telefon numarasını kontrol edin");
        }
        if (checkEmailAndWebSite(employer)!=null){
            return new ErrorResult("Eposta ve domain eşleşmiyor");
        }
        if (employer.getPassword().isEmpty() || employer.getEmail().isEmpty() || employer.getWebSite().isEmpty() || employer.getCompanyName().isEmpty() || employer.getPhoneNumber().isEmpty()){
            return new ErrorResult("Tüm alanları doldurmak zorunludur");
        }
        //if (emailValidationService.emailValidation(employer.getEmail())){
        //    return new ErrorResult("Lütfen gönderilen doğrulama linkine tıklayınız");
        //}
        //if (companyStaffValidationService.companyStaffValidation(employer.getEmail())){
        //    return new ErrorResult("Şirketiniz, sistem personeli tarafından onaylanmamıştır");
        //}
        this.employerDao.save(employer);
        return new SuccessResult("İşveren başarıyla sisteme kayıt edildi");
    }

    @Override
    public DataResult<List<Employer>> getAll() {

        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İşverenler listelendi");
    }

    private ErrorResult checkEmailAndWebSite(Employer employer){
        String website=employer.getWebSite();
        String email=employer.getEmail();
        String[] emailSplit=email.split("@");
        String[] webSiteSplit=website.split("www.");
        if (!emailSplit[1].equals(webSiteSplit[1])){
            return new ErrorResult("Email ve web-site domain adresi aynı olmalıdır");
        }
        return null;
    }
    //public DataResult<List<JobAdvertisementDto>> addJobPost(JobAdvertisementDto jobAdvertisementDto){
    //    return  new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisementDto.getJobTitle(),jobAdvertisementDto.getCompanyName());
    //}


}
