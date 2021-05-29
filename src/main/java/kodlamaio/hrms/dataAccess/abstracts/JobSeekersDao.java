package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.JobSeekers;

@Repository
public interface JobSeekersDao extends JpaRepository<JobSeekers, Integer>{
	JobSeekers findByEmail (String email);
	JobSeekers findByNationalityId(String nationalityId);
}
