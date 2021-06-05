package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "user_id")
public class Candidate extends User{

    @NotNull
    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @NotBlank
    @Column(name = "birth_year")
    private String birthYear;

    @NotNull
    @NotBlank
    @Column(name = "nationalty_id")
    private String nationalityId;

    @OneToMany(mappedBy = "candidate")
    private List<CvExperience> cvExperiences;

    @OneToMany(mappedBy = "candidate")
    private List<CvAbout> cvAbouts;

    @OneToMany(mappedBy = "candidate")
    private List<CvLanguage> cvLanguages;

    @OneToMany(mappedBy = "candidate")
    private List<CvLink> cvLinks;

    @OneToMany(mappedBy = "candidate")
    private List<CvPhoto>   cvPhotos;

    @OneToMany(mappedBy = "candidate")
    private List<CvSchool>  cvSchools;

    @OneToMany(mappedBy = "candidate")
    private List<CvPrLanguage>  cvPrLanguages;



    public Candidate(int id,String email,String password,String firstName,String lastName,String birthYear,String nationalityId){
        super(id,email,password);
        this.birthYear=birthYear;
        this.firstName=firstName;
        this.lastName=lastName;
        this.nationalityId=nationalityId;
    }
}
