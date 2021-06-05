package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CvLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvLanguageDao extends JpaRepository<CvLanguage,Integer> {
    List<CvLanguage> getByCandidateId(int id);
}
