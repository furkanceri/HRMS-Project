package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("İş ilanı eklendi");
    }

    @Override
    public Result delete(int id) {
        if (getById(id).getData().isActive()){
            return new ErrorResult("İş ilanı silinemedi");
        }
        this.jobAdvertisementDao.deleteById(id);
        return new SuccessResult("İş ilanı silindi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByisActiveTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByisActiveTrue(),"Aktif iş ilanları listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByisActiveTrueOrderByPostDate() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByisActiveTrueOrderByPostDate(),"İş ilanları tarihe göre sıralandı");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByisActiveTrueAndEmployer_CompanyName(String companyName) {

        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByisActiveTrueAndEmployer_CompanyName(companyName),"Şirket iş ilanları listelendi");
    }

    @Override
    public DataResult<JobAdvertisement> getById(int id) {
        return new SuccessDataResult<JobAdvertisement>(jobAdvertisementDao.getOne(id));
    }
}
