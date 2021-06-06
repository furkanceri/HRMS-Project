package kodlamaio.hrms.core.utilities.adapters.concretes;

import kodlamaio.hrms.core.utilities.adapters.abstracts.EmailValidationService;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailValidationManager implements EmailValidationService {

    @Override
    public boolean emailValidation(String email) {
        System.out.println("Eposta doğrulaması başarılı "+email);
        return true;
    }


}
