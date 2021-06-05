package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.CvExperience;
import kodlamaio.hrms.entities.dtos.CvDto;

import java.util.List;

public interface CvExperienceService {
    Result add(CvExperience cvExperience);
    Result addAll(List<CvExperience> cvExperiences);
    DataResult<List<CvDto>> getAll();
    SuccessDataResult<List<CvExperience>> getByCandidateIdOrderByStartDate(int id);
}
