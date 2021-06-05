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
@Table(name = "cv_schools")
public class CvSchool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_school_id")
    private int cvSchoolId;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "school_type")
    private String schoolFaculity;

    @Column(name = "school_department")
    private String schoolSection;

    @Column(name = "school_begining_date")
    private LocalDate startDate;

    @Column(name = "school_graduation_date")
    private LocalDate endDate;

    @ManyToOne()
    @JsonIgnore()
    @JoinColumn(name = "user_id")
    private Candidate candidate;
}
