package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekersService;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekersDao;
import kodlamaio.hrms.entities.concretes.JobSeekers;


@Service
public class JobSeekersManager implements JobSeekersService{

	@Autowired
	private JobSeekersDao jobSeekersDao;
	
	
	
	@Override
	public List<JobSeekers> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
