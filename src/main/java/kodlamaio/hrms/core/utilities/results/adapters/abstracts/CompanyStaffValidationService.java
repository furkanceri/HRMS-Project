package kodlamaio.hrms.core.utilities.results.adapters.abstracts;

import kodlamaio.hrms.entities.concretes.Employers;

public interface CompanyStaffValidationService {

	public boolean companyStaffValidation(Employers employers, String email);
}
