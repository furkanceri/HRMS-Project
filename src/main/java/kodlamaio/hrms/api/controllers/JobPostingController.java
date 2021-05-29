package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;

@RestController
@RequestMapping("/api/jobPosting")
public class JobPostingController {

	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}
	
	@GetMapping("/activeJobs")
	public DataResult<List<JobPosting>> getAllActiveJobs(){
		return this.jobPostingService.getByisActiveJobPostings();
	}
	
	@PostMapping("/addJobs")
	public Result add(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.add(jobPosting);
	}
	
	@PostMapping("/deleteJobs")
	public Result delete(int id) {
		return this.jobPostingService.delete(id);
	}
	
	@PostMapping("/updateJobs")
	public Result update(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.update(jobPosting);
	}
	
//	@PostMapping("/listByDateJobs")
//	public DataResult<List<JobPosting>> getByisActiveTrueOrderBydeclarationDate(){
//		return this.jobPostingService.getByisActiveTrueOrderBydeclarationDate();
//	}
	
	@PostMapping("/companyName")
	public DataResult<List<JobPosting>> getByisActiveAndEmployers_companyName(String companyName){
		return this.jobPostingService.getByisActiveAndEmployers_companyName(companyName);
	}
}
