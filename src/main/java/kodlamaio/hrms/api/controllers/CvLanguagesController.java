package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CvLanguageService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.CvLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cvlanguages")
public class CvLanguagesController {
    private CvLanguageService cvLanguageService;

    @Autowired
    public CvLanguagesController(CvLanguageService cvLanguageService) {
        this.cvLanguageService = cvLanguageService;
    }
    @PostMapping("/add")
    public Result add(@RequestBody CvLanguage cvLanguage){
        this.cvLanguageService.add(cvLanguage);
        return new SuccessResult("succesfully completed");
    }
}
