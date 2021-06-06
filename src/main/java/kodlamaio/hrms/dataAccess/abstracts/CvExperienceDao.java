package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CvExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvExperienceDao extends JpaRepository<CvExperience,Integer> {
    List<CvExperience> getByCandidateIdOrderByStartDate(int id);
}
