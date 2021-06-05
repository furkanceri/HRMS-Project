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
@Table(name = "cv_about")
public class CvAbout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_about_id")
    private int cvAboutId;

    @Column(name = "cv_about")
    private String cvAbout;

    @Column(name = "cv_create_date", columnDefinition = "Date default CURRENT_DATE")
    private LocalDate createDate=LocalDate.now();

    @Column(name = "is_active", columnDefinition = "boolean default true")
    private boolean isActive=true;

    @ManyToOne()
    @JsonIgnore()
    @JoinColumn(name = "user_id")
    private Candidate candidate;
}
