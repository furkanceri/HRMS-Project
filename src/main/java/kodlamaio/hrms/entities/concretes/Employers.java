package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="companies")
@PrimaryKeyJoinColumn(name = "company_id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPostings"})
public class Employers extends Users{
	
	//@Id
	//@GeneratedValue
	//@Column(name="company_id")
	//private int employersId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_site")
	private String webSite;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@OneToMany(mappedBy = "employers")
	private List<JobPosting> jobPostings;

	public Employers(int id, String email, String companyName, String webSite, String password, String phoneNumber) {
		super(id, email, password);
		this.companyName=companyName;
		this.phoneNumber=phoneNumber;
		this.webSite=webSite;
	}
	
	
	

}
