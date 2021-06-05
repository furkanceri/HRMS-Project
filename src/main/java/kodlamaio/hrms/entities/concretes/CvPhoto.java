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
@Table(name = "cv_photo")
public class CvPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_photo_id")
    private int cvPhotoId;

    @Column(name = "photo")
    private String photo;

    @ManyToOne()
    @JsonIgnore()
    @JoinColumn(name = "user_id")
    private Candidate candidate;
}
