package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CvDto;

import java.util.List;

public interface CandidateService {

    Result add(Candidate candidate);
    DataResult<List<Candidate>> getAll();
    DataResult<Candidate> getById(int id);
    DataResult<CvDto> getCvById(int id);
}
