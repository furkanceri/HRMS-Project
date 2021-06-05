package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "programing_technologies")
public class CvPrLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "programing_id")
    private int programmingId;

    @Column(name = "programing_technology_name")
    private String programmingTechName;

    @ManyToOne()
    @JsonIgnore()
    @JoinColumn(name = "user_id")
    private Candidate candidate;
}
