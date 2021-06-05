package kodlamaio.hrms.core.utilities.adapters.concretes;

import kodlamaio.hrms.core.utilities.adapters.abstracts.CompanyStaffValidationService;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.stereotype.Service;

@Service
public class CompanyStaffValidationManager implements CompanyStaffValidationService {
    @Override
    public boolean companyStaffValidation(String email) {
        System.out.println(email.length()+" Şirket, sistem personeli tarafından onaylandı");
        return true;
    }
}
