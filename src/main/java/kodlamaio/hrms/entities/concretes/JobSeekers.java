package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidate_users")
@PrimaryKeyJoinColumn(name = "id")
public class JobSeekers extends Users{
	
	
	//@Id
	//@GeneratedValue()
	//@Column(name="job_seekers_id")
	//private int jobSeekersId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="date_of_birth")
	private String birthYear;
	
	@Column(name="identity_number")
	private String nationalityId;
	
	public JobSeekers (int id, String email, String password, String firstName, String lastName, String birthYear, String nationalityId) {
		super(id,email,password);
		this.firstName=firstName;
		this.lastName=lastName;
		this.birthYear=birthYear;
		this.nationalityId=nationalityId;
	}
	
}
