package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Jobs;

public interface JobsService {

	Result add(Jobs jobs);
	DataResult<List<Jobs>> getAll();
	
}
