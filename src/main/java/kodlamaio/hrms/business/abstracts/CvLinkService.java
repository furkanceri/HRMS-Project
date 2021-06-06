package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.CvLink;
import kodlamaio.hrms.entities.dtos.CvDto;

import java.util.List;

public interface CvLinkService {
    Result add(CvLink cvLink);
    Result addAll(List<CvLink> cvLinks);
    DataResult<List<CvDto>> getAll();
    SuccessDataResult<List<CvLink>> getByCandidateId(int id);
}
