package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobManager implements JobService {

    private JobDao jobDao;

    @Autowired
    public JobManager(JobDao jobDao) {
        this.jobDao = jobDao;
    }

    @Override
    public Result add(Job job) {
        if (job.getJobTitle().isEmpty()){
            return new ErrorResult("Boş alan bırakılamaz");
        }
        if (this.jobDao.findByJobTitle(job.getJobTitle())!=null){
            return new ErrorResult("Bu pozisyon daha önce sisteme kayıt edilmiş");
        }
        this.jobDao.save(job);
        return new SuccessDataResult<Job>(job,"İş pozisyonu başarıyla kaydedildi");
    }

    @Override
    public DataResult<List<Job>> getAll() {

        return new SuccessDataResult<List<Job>>(this.jobDao.findAll());
    }
}
