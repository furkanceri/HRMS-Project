package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobs")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisement"})
public class Job{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @NotBlank
    @Column(name = "job_id")
    private int jobId;

    @NotNull
    @NotBlank
    @Column(name = "job_titles")
    private String jobTitle;

    @OneToMany(mappedBy = "job")
    private List<JobAdvertisement> JobAdvertisement;
}
