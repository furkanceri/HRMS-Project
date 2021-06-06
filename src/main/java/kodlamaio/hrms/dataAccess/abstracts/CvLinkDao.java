package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CvLink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvLinkDao extends JpaRepository<CvLink,Integer> {
    List<CvLink>    getByCandidateId(int id);
}
