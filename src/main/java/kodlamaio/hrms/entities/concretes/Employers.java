package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name="employers")
public class Employers {
	
	@Id
	@GeneratedValue
	@Column(name="employers_id")
	private int employersId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_site")
	private String companyWebSite;
	
	@Column(name="phone_number")
	private String companyPhoneNumber;
	
	@Column(name="company_email")
	private String companyEmail;

}
