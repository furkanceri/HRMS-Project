package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CvExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvExperienceDao;
import kodlamaio.hrms.entities.concretes.CvExperience;
import kodlamaio.hrms.entities.dtos.CvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvExperienceManager implements CvExperienceService {
    private CvExperienceDao cvExperienceDao;

    @Autowired
    public CvExperienceManager(CvExperienceDao cvExperienceDao) {
        this.cvExperienceDao = cvExperienceDao;
    }

    @Override
    public Result add(CvExperience cvExperience) {
        this.cvExperienceDao.save(cvExperience);
        return new SuccessResult("Deneyim eklendi");
    }

    @Override
    public Result addAll(List<CvExperience> cvExperiences) {
        this.cvExperienceDao.saveAll(cvExperiences);
        return new SuccessResult("Deneyimler eklendi");
    }

    @Override
    public DataResult<List<CvDto>> getAll() {
        return new SuccessDataResult<List<CvDto>>("Data listelendi");
    }

    @Override
    public SuccessDataResult<List<CvExperience>> getByCandidateIdOrderByStartDate(int id) {
        return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.getByCandidateIdOrderByStartDate(id),"getirildi");
    }
}
