package kodlamaio.hrms.business.concretes;

import javassist.expr.NewArray;
import kodlamaio.hrms.business.abstracts.CvLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvLanguageDao;
import kodlamaio.hrms.entities.concretes.CvLanguage;
import kodlamaio.hrms.entities.dtos.CvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvLanguageManager implements CvLanguageService {
    private CvLanguageDao cvLanguageDao;

    @Autowired
    public CvLanguageManager(CvLanguageDao cvLanguageDao) {
        this.cvLanguageDao = cvLanguageDao;
    }

    @Override
    public Result add(CvLanguage cvLanguage) {
        this.cvLanguageDao.save(cvLanguage);
        return new SuccessResult("Dil eklendi");
    }

    @Override
    public Result addAll(List<CvLanguage> cvLanguages) {
        this.cvLanguageDao.saveAll(cvLanguages);
        return new SuccessResult("Diller eklendi");
    }

    @Override
    public DataResult<List<CvDto>> getAll() {
        return new SuccessDataResult<List<CvDto>>("Data listelendi");
    }

    @Override
    public SuccessDataResult<List<CvLanguage>> getByCandidateId(int id) {
        return new SuccessDataResult<List<CvLanguage>>(this.cvLanguageDao.getByCandidateId(id),"getirildi");
    }
}
