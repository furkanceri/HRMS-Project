package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {

    Result add(JobAdvertisement jobAdvertisement);
    Result delete(int id);

    DataResult<List<JobAdvertisement>> getByisActiveTrue();
    DataResult<List<JobAdvertisement>> getByisActiveTrueOrderByPostDate();
    DataResult<List<JobAdvertisement>> getByisActiveTrueAndEmployer_CompanyName(String companyName);
    DataResult<JobAdvertisement> getById(int id);
}
