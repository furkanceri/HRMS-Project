package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeekers;


public interface JobSeekersDao extends JpaRepository<JobSeekers, Integer>{
	JobSeekers findByNationalityId(String nationalityId);
}
