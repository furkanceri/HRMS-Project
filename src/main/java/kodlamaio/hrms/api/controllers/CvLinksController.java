package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CvLinkService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.CvLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cvlinks")
public class CvLinksController {
    private CvLinkService  cvLinkService;

    @Autowired
    public CvLinksController(CvLinkService cvLinkService) {
        this.cvLinkService = cvLinkService;
    }
    @PostMapping("/add")
    public Result add(@RequestBody CvLink cvLink){
        this.cvLinkService.add(cvLink);
        return new SuccessResult("succesfully completed");
    }
}
