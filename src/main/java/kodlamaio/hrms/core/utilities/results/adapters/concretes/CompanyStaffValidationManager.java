package kodlamaio.hrms.core.utilities.results.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.adapters.abstracts.CompanyStaffValidationService;
import kodlamaio.hrms.entities.concretes.Employers;

@Service
public class CompanyStaffValidationManager implements CompanyStaffValidationService{

	@Override
	public boolean companyStaffValidation(Employers employers, String email) {
		System.out.println(employers.getCompanyName()+" isimli şirket sistem personeli tarafından onaylandı");
		return true;
	}

}
