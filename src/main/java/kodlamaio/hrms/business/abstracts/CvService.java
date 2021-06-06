package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CvDto;

public interface CvService {
    Result add(CvDto cvDto,int id);
}
