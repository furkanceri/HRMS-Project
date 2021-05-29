package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;

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
@Table(name="candidates")
@PrimaryKeyJoinColumn(name = "user_id")
public class JobSeekers extends Users{
	
	
	//@Id
	//@GeneratedValue()
	//@Column(name="user_id")
	//private int jobSeekersId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="birth_year")
	private String birthYear;
	
	@Column(name="nationalty_id")
	private String nationalityId;
	
	public JobSeekers(int id, String email, String password, String firstName, String lastName, String nationalityId, String birthYear) {
		super(id, email, password);
		this.birthYear=birthYear;
		this.firstName=firstName;
		this.lastName=lastName;
		this.nationalityId=nationalityId;
	}
	
	
	
	
}
