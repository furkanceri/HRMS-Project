package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_postings")
public class JobPosting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "job_details")
	private String jobDetail;
	
	@Column(name = "min_wage")
	private double minSalary;
	
	@Column(name = "max_wage")
	private double maxSalary;
	
	@Column(name = "number_of_open_position")
	private int activePositionNumber;
	
	@Column(name = "last_apply_date")
	private LocalDate applicationDeadline;
	
	@Column(name = "isActive")
	private boolean isActive;
	
	@Column(name = "posted_date")
	private LocalDate declarationDate;
	
	@ManyToOne()
	@JoinColumn(name = "company_id")
	private Employers employers;
	
	@ManyToOne()
	@JoinColumn(name = "job_id")
	private Jobs jobs;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private Cities cities;
}
