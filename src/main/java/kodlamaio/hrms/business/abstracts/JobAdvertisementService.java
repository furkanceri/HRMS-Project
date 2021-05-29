package kodlamaio.hrms.business.abstracts;

import java.util.List;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	Result add(JobAdvertisement jobAdvertisements );
	Result delete(int id);
	DataResult<List<JobAdvertisement>> getByisActiveTrue();
	DataResult<List<JobAdvertisement>> getByisActiveTrueAndEmployers_CompanyName(String companyName);
	DataResult<List<JobAdvertisement>> getByisActiveTrueOrderByReleaseDate();
	DataResult<JobAdvertisement> getById(int id);
	
}
