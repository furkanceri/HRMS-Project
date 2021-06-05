package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobpost")
public class JobAdvertisementController {
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement){
        return this.jobAdvertisementService.add(jobAdvertisement);
    }
    @PostMapping("/delete")
    public Result delete(int id){
        return this.jobAdvertisementService.delete(id);
    }
    @GetMapping("/getByisActiveTrueAndEmployer_CompanyName")
    public DataResult<List<JobAdvertisement>> getByisActiveTrueAndEmployer_CompanyName(@RequestParam String companyName){
        return this.jobAdvertisementService.getByisActiveTrueAndEmployer_CompanyName(companyName);
    }
    @GetMapping("/getByisActiveTrue")
    public DataResult<List<JobAdvertisement>> getByisActiveTrue(){
        return this.jobAdvertisementService.getByisActiveTrue();
    }
    @GetMapping("/getByisActiveTrueOrderByPostDate")
    public DataResult<List<JobAdvertisement>> getByisActiveTrueOrderByPostDate(){
        return this.jobAdvertisementService.getByisActiveTrueOrderByPostDate();
    }
}
