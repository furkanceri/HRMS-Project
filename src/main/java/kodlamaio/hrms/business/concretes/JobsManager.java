package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobsService;
import kodlamaio.hrms.dataAccess.abstracts.JobsDao;
import kodlamaio.hrms.entities.concretes.Jobs;


@Service
public class JobsManager implements JobsService{

	@Autowired
	private JobsDao jobsDao;
	
	
	@Override
	public List<Jobs> getAll() {
		
		return this.jobsDao.findAll();
	}

}
