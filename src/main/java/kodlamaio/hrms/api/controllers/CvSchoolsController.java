package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CvSchoolService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.CvSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cvschools")
public class CvSchoolsController {
    private CvSchoolService cvSchoolService;

    @Autowired
    public CvSchoolsController(CvSchoolService cvSchoolService) {
        this.cvSchoolService = cvSchoolService;
    }

    public Result add(CvSchool cvSchool){
        this.cvSchoolService.add(cvSchool);
        return new SuccessResult("successfully completed");
    }
}
