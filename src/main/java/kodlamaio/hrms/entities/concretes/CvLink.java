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
@Table(name = "cv_links")
public class CvLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_link_id")
    private int cvLinkId;

    @Column(name = "link_name")
    private String linkName;

    @ManyToOne()
    @JsonIgnore()
    @JoinColumn(name = "id")
    private Candidate candidate;
}
