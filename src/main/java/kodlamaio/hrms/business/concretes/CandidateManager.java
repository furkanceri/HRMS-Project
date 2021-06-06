package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.*;
import kodlamaio.hrms.core.utilities.adapters.abstracts.EmailValidationService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private CandidateDao candidateDao;
    private EmailValidationService emailValidationService;
    private CvAboutService cvAboutService;
    private CvLinkService cvLinkService;
    private CvExperienceService cvExperienceService;
    private CvSchoolService cvSchoolService;
    private CvLanguageService cvLanguageService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, EmailValidationService emailValidationService, CvAboutService cvAboutService, CvLinkService cvLinkService, CvExperienceService cvExperienceService, CvSchoolService cvSchoolService, CvLanguageService cvLanguageService) {
        this.candidateDao = candidateDao;
        this.emailValidationService = emailValidationService;
        this.cvAboutService = cvAboutService;
        this.cvLinkService = cvLinkService;
        this.cvExperienceService = cvExperienceService;
        this.cvSchoolService = cvSchoolService;
        this.cvLanguageService = cvLanguageService;
    }

    @Override
    public Result add(Candidate candidate) {
        if (this.candidateDao.findByNationalityId(candidate.getNationalityId())!=null || this.candidateDao.findByEmail(candidate.getEmail())!=null){
            return new ErrorResult("Bu email veya Kimlik numarası daha önce sisteme kayıt edilmiş");
        }
        if (candidate.getPassword().isEmpty() || candidate.getEmail().isEmpty() || candidate.getNationalityId().isEmpty() || candidate.getLastName().isEmpty()
                || candidate.getFirstName().isEmpty() || candidate.getBirthYear().isEmpty()){
            return  new ErrorResult("Tüm alanların doldurulması zorunludur");
        }
        //if (emailValidationService.emailValidation(candidate.getEmail())){
        //    return new ErrorResult("Lütfen gönderilen onaylama linkine tıklayınız");
        //}
        this.candidateDao.save(candidate);
        return new SuccessResult("İş arayan kullanıcı başarıyla eklendi");
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll()," İş arayanlar listelendi");
    }

    @Override
    public DataResult<Candidate> getById(int id) {
        return new SuccessDataResult<Candidate>(this.candidateDao.findById(id).get());
    }

    @Override
    public DataResult<CvDto> getCvById(int id) {
        CvDto cvDto=new CvDto();
        cvDto.setCandidate(this.getById(id).getData());
        cvDto.setCvAbouts(this.cvAboutService.getByCandidateId(id).getData());
        cvDto.setCvExperiences(this.cvExperienceService.getByCandidateIdOrderByStartDate(id).getData());
        cvDto.setCvLanguages(this.cvLanguageService.getByCandidateId(id).getData());
        cvDto.setCvSchools(this.cvSchoolService.getByCandidateIdOrderByStartDate(id).getData());
        cvDto.setCvLinks(this.cvLinkService.getByCandidateId(id).getData());
        return new SuccessDataResult(cvDto);
    }
}
