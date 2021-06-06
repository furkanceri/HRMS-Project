package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CvAbout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvAboutDao extends JpaRepository<CvAbout,Integer> {
    List<CvAbout> getByCandidateId(int id);
}
