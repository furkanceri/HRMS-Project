package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CompanyStaffService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CompanyStaff;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyStaffManager implements CompanyStaffService {
    @Override
    public DataResult<List<CompanyStaff>> getAll() {
        return null;
    }
}
