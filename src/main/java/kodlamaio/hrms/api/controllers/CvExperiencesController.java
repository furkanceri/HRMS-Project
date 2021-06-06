package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CvExperienceService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.CvExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cvexperience")
public class CvExperiencesController {
    private CvExperienceService cvExperienceService;

    @Autowired
    public CvExperiencesController(CvExperienceService cvExperienceService) {
        this.cvExperienceService = cvExperienceService;
    }
    @PostMapping("/add")
    public Result add(@RequestBody CvExperience cvExperience){
        this.cvExperienceService.add(cvExperience);
        return new SuccessResult("successfully completed");
    }
}
