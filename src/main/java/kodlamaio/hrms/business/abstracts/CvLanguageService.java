package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.CvLanguage;
import kodlamaio.hrms.entities.dtos.CvDto;

import java.util.List;

public interface CvLanguageService {
    Result add(CvLanguage cvLanguage);
    Result addAll(List<CvLanguage> cvLanguages);
    DataResult<List<CvDto>> getAll();
    SuccessDataResult<List<CvLanguage>> getByCandidateId(int id);
}
