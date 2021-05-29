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

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_postings")
public class JobAdvertisement {

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
	private int openPosition;
	
	@Column(name = "last_apply_date", columnDefinition = "Date default CURRENT_DATE")
	private LocalDate applicationDeadline=LocalDate.now();
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "posted_date", columnDefinition = "Date default CURRENT_DATE")
	private LocalDate releaseDate=LocalDate.now();
	
	@ManyToOne
	@JoinColumn(name = "job_id")
	private Jobs jobs;
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Employers employers;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private Cities cities;
}
