package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.*;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CvManager implements CvService {
    private CandidateService candidateService;
    private CvAboutService cvAboutService;
    private CvSchoolService cvSchoolService;
    private CvExperienceService cvExperienceService;
    private CvLanguageService cvLanguageService;
    private CvLinkService cvLinkService;

    @Autowired
    public CvManager(CandidateService candidateService, CvAboutService cvAboutService, CvSchoolService cvSchoolService, CvExperienceService cvExperienceService, CvLanguageService cvLanguageService, CvLinkService cvLinkService) {
        this.candidateService = candidateService;
        this.cvAboutService = cvAboutService;
        this.cvSchoolService = cvSchoolService;
        this.cvExperienceService = cvExperienceService;
        this.cvLanguageService = cvLanguageService;
        this.cvLinkService = cvLinkService;
    }

    @Override
    public Result add(CvDto cvDto, int id) {

        Candidate candidate=candidateService.getById(id).getData();
        cvDto.setCandidate(candidate);

        cvDto.getCvSchools().forEach(cvSchool -> cvSchool.setCandidate(candidate));
        cvSchoolService.addAll(cvDto.getCvSchools());

        cvDto.getCvLanguages().forEach(cvLanguage -> cvLanguage.setCandidate(candidate));
        cvLanguageService.addAll(cvDto.getCvLanguages());

        cvDto.getCvExperiences().forEach(cvExperience -> cvExperience.setCandidate(candidate));
        cvExperienceService.addAll(cvDto.getCvExperiences());

        cvDto.getCvLinks().forEach(cvLink -> cvLink.setCandidate(candidate));
        cvLinkService.addAll(cvDto.getCvLinks());

        cvDto.getCvAbouts().forEach(cvAbout -> cvAbout.setCandidate(candidate));
        cvAboutService.addAll(cvDto.getCvAbouts());

        return new SuccessResult("Eklendi");
    }
}
