package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_postings")
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;

    @Column(name = "job_details")
    private String jobDetail;

    @Column(name = "min_wage")
    private double minSalary;

    @Column(name = "max_wage")
    private double maxSalary;

    @Column(name = "number_of_open_position")
    private int openPosition;

    @Column(name = "last_apply_date")
    private LocalDate applicationDeadline;

    @Column(name = "posted_date")
    private LocalDate postDate;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private Cities cities;
}
