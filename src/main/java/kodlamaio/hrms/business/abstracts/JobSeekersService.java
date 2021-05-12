package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.entities.concretes.JobSeekers;

public interface JobSeekersService {

	List<JobSeekers> getAll();
}
