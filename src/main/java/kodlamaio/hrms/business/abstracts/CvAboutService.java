package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvAbout;

import java.util.List;

public interface CvAboutService {
    Result add(CvAbout cvAbout);
    Result addAll(List<CvAbout> cvAbouts);
    DataResult<List<CvAbout>> getByCandidateId(int id);
}
