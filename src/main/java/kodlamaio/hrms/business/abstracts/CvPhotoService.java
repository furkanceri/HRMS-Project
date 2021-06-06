package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.CvPhoto;
import kodlamaio.hrms.entities.dtos.CvDto;

import java.util.List;

public interface CvPhotoService {
    Result add(CvPhoto cvPhoto);
    Result addAll(List<CvPhoto> cvPhotos);
    DataResult<List<CvDto>> getAll();
    SuccessDataResult<List<CvPhoto>> getByCandidateId(int id);
}
