package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CompanyStaff;

public interface CompanyStaffDao extends JpaRepository<CompanyStaff, Integer>{

}
