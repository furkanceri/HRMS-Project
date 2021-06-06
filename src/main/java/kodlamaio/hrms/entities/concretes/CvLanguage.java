package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_languages")
public class CvLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_language_id")
    private int cvLanguageId;

    @Column(name = "language_name")
    private String languageName;

    @Min(value = 1)
    @Max(value = 5)
    @Column(name = "language_level")
    private int languageLevel;

    @ManyToOne()
    @JsonIgnore()
    @JoinColumn(name = "id")
    private Candidate candidate;
}
