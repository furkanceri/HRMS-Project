package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CompanyStaffService;
import kodlamaio.hrms.dataAccess.abstracts.CompanyStaffDao;
import kodlamaio.hrms.entities.concretes.CompanyStaff;



@Service
public class CompanyStaffManager implements CompanyStaffService{

	
	@Autowired
	private CompanyStaffDao companyStaffDao;
	
	
	@Override
	public List<CompanyStaff> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}