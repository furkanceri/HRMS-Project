package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Jobs;
import kodlamaio.hrms.entities.concretes.Users;

public interface JobsDao extends JpaRepository<Jobs, Integer>{
	Jobs findByJobs(String jobs);
}
