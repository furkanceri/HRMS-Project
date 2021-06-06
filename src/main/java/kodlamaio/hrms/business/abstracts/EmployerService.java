package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {

    Result add(Employer employer);
    DataResult<List<Employer>> getAll();
}
