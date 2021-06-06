package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CvSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvSchoolDao;
import kodlamaio.hrms.entities.concretes.CvSchool;
import kodlamaio.hrms.entities.dtos.CvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvSchoolManager implements CvSchoolService {
    private CvSchoolDao cvSchoolDao;

    @Autowired
    public CvSchoolManager(CvSchoolDao cvSchoolDao) {
        this.cvSchoolDao = cvSchoolDao;
    }

    @Override
    public Result add(CvSchool cvSchool) {
        this.cvSchoolDao.save(cvSchool);
        return new SuccessResult("Okul eklendi");
    }

    @Override
    public Result addAll(List<CvSchool> cvSchools) {
        this.cvSchoolDao.saveAll(cvSchools);
        return new SuccessResult("Okullar eklendi");
    }

    @Override
    public DataResult<List<CvDto>> getAll() {
        return new SuccessDataResult<List<CvDto>>("Data listelendi");
    }

    @Override
    public DataResult<List<CvSchool>> getByCandidateIdOrderByStartDate(int id) {
        return new SuccessDataResult<List<CvSchool>>(this.cvSchoolDao.getByCandidateIdOrderByStartDate(id),"getirildi");
    }
}
