package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CvPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvPhotoDao extends JpaRepository<CvPhoto,Integer> {
    List<CvPhoto> getByCandidateId(int id);
}
