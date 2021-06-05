package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> getByisActiveTrue();
    List<JobAdvertisement> getByisActiveTrueOrderByPostDate();

    //@Query("select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto(ja.applicationDeadline,ja.postDate, ja.openPosition,e.companyName) From Employer e inner join e.JobAdvertisement ja")
    List<JobAdvertisement> getByisActiveTrueAndEmployer_CompanyName(String companyName);
    List<JobAdvertisement> getById(int id);
}
