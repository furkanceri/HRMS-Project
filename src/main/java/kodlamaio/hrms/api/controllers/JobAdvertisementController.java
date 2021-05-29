package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobpost")
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/activejobs")
	public DataResult<List<JobAdvertisement>> getByisActive(){
		return this.jobAdvertisementService.getByisActiveTrue();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PostMapping("/delete")
	public Result delete(int id) {
		return this.jobAdvertisementService.delete(id);
	}
	
	@GetMapping("/getByisActiveAndCompanyName")
	public DataResult<List<JobAdvertisement>> getByisActiveAndCompanyName(@RequestParam String companyName){
		return this.jobAdvertisementService.getByisActiveTrueAndEmployers_CompanyName(companyName);
	}
	@GetMapping("/getAllisActiveAndOrderByReleaseDate")
	public DataResult<List<JobAdvertisement>> getAllisActiveAndOrderByReleaseDate(){
		return this.jobAdvertisementService.getByisActiveTrueOrderByReleaseDate();
	}
	
}
