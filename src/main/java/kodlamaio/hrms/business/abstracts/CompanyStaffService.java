package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CompanyStaff;

import java.util.List;

public interface CompanyStaffService {

    DataResult<List<CompanyStaff>> getAll();
}
