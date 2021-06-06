package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.CvSchool;
import kodlamaio.hrms.entities.dtos.CvDto;

import java.util.List;

public interface CvSchoolService {
    Result add(CvSchool cvSchool);
    Result addAll(List<CvSchool> cvSchools);
    DataResult<List<CvDto>> getAll();
    DataResult<List<CvSchool>> getByCandidateIdOrderByStartDate(int id);
}
