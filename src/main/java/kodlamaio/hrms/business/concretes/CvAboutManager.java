package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CvAboutService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvAboutDao;
import kodlamaio.hrms.entities.concretes.CvAbout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvAboutManager implements CvAboutService {
    private CvAboutDao cvAboutDao;

    @Autowired
    public CvAboutManager(CvAboutDao cvAboutDao) {
        this.cvAboutDao = cvAboutDao;
    }

    @Override
    public Result add(CvAbout cvAbout) {
        this.cvAboutDao.save(cvAbout);
        return new SuccessResult("Hakkında eklendi");
    }

    @Override
    public Result addAll(List<CvAbout> cvAbouts) {
        this.cvAboutDao.saveAll(cvAbouts);
        return new SuccessResult("Hakkındalar eklendi");
    }

    @Override
    public DataResult<List<CvAbout>> getByCandidateId(int id) {
        return new SuccessDataResult<List<CvAbout>>(this.cvAboutDao.getByCandidateId(id),"getirildi");
    }
}
