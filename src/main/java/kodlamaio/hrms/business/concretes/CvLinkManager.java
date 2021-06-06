package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CvLinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvLinkDao;
import kodlamaio.hrms.entities.concretes.CvLink;
import kodlamaio.hrms.entities.dtos.CvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvLinkManager implements CvLinkService {
    private CvLinkDao cvLinkDao;

    @Autowired
    public CvLinkManager(CvLinkDao cvLinkDao) {
        this.cvLinkDao = cvLinkDao;
    }

    @Override
    public Result add(CvLink cvLink) {
        this.cvLinkDao.save(cvLink);
        return new SuccessResult("Link eklendi");
    }

    @Override
    public Result addAll(List<CvLink> cvLinks) {
        this.cvLinkDao.saveAll(cvLinks);
        return new SuccessResult("Diller eklendi");
    }

    @Override
    public DataResult<List<CvDto>> getAll() {
        return new SuccessDataResult<List<CvDto>>("Data listelendi");
    }

    @Override
    public SuccessDataResult<List<CvLink>> getByCandidateId(int id) {
        return new SuccessDataResult<List<CvLink>>(this.cvLinkDao.getByCandidateId(id),"getirildi");
    }
}
