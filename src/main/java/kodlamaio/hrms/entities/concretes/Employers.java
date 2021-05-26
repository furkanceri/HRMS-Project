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
@Table(name="employer_users")
@PrimaryKeyJoinColumn(name = "id")
public class Employers extends Users{
	
	//@Id
	//@GeneratedValue
	//@Column(name="employers_id")
	//private int employersId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_adress")
	private String companyWebSite;
	
	@Column(name="phone_number")
	private String companyPhoneNumber;

	public Employers(int id, String email, String password, String companyName, String companyWebSite, String companyPhoneNumber) {
		super(id, email, password);
		this.companyName=companyName;
		this.companyPhoneNumber=companyPhoneNumber;
		this.companyWebSite=companyWebSite;
	}
	
	

}
