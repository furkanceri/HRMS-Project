package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CvPhotoService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CvPhotoDao;
import kodlamaio.hrms.entities.concretes.CvPhoto;
import kodlamaio.hrms.entities.dtos.CvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvPhotoManager implements CvPhotoService {
    private CvPhotoDao cvPhotoDao;

    @Autowired
    public CvPhotoManager(CvPhotoDao cvPhotoDao) {
        this.cvPhotoDao = cvPhotoDao;
    }

    @Override
    public Result add(CvPhoto cvPhoto) {
        return null;
    }

    @Override
    public Result addAll(List<CvPhoto> cvPhotos) {
        return null;
    }

    @Override
    public DataResult<List<CvDto>> getAll() {
        return null;
    }

    @Override
    public SuccessDataResult<List<CvPhoto>> getByCandidateId(int id) {
        return null;
    }
}
