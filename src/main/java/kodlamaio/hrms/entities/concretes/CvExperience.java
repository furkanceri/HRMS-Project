package kodlamaio.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_experience")
public class CvExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_experience_id")
    private int cvExperienceId;

    @Column(name = "other_company")
    private String companyName;

    @Column(name = "begining_date")
    private LocalDate startDate;

    @Column(name = "ending_date")
    private LocalDate endDate;

    @Column(name = "cv_experience_name")
    private String experiencePosition;

    @OneToOne()
    @JsonIgnore()
    @JoinColumn(name = "company_id")
    private Employer employer;

    @ManyToOne()
    @JsonIgnore()
    @JoinColumn(name = "id")
    private Candidate candidate;
}
