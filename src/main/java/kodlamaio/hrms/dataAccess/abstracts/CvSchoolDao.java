package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CvSchool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvSchoolDao extends JpaRepository<CvSchool,Integer> {
    List<CvSchool> getByCandidateIdOrderByStartDate(int id);
}
