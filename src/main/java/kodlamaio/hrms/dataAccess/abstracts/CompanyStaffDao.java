package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CompanyStaff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyStaffDao extends JpaRepository<CompanyStaff,Integer> {
}
