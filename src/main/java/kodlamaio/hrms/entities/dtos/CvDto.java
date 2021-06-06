package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
    private Candidate candidate;

    private List<CvAbout>   cvAbouts;
    private List<CvSchool>  cvSchools;
    private List<CvExperience>  cvExperiences;
    private List<CvLanguage>    cvLanguages;
    private List<CvPhoto>   cvPhotos;
    private List<CvLink>    cvLinks;
    private List<CvPrLanguage>  cvPrLanguages;
}
