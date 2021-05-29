package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobPosting;


public interface JobPostingDao extends JpaRepository<JobPosting,Integer>{

	List<JobPosting> getByisActiveTrue();
	List<JobPosting> getByisActiveTrueAndEmployers_companyName(String companyName);
	//List<JobPosting> getByIsActiveTrueOrderBydeclarationDate();
	
}
