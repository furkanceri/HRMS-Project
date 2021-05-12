package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name="job_seekers")
public class JobSeekers {
	
	
	@Id
	@GeneratedValue
	@Column(name="job_seekers_id")
	private int jobSeekersId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="birth_year")
	private int birthYear;
	
	@Column(name="nationality_id")
	private long nationalityId;
	
}
