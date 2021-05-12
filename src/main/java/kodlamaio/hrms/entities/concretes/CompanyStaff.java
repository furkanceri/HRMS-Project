package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name="company_staff")
public class CompanyStaff {
	
	@Id
	@GeneratedValue
	@Column(name="company_staff_id")
	private int companyStaffId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="starting_date_of_work")
	private Date startingDateOfWork;
	
	@Column(name="department")
	private String department;
	
	@Column(name="task")
	private String task;
}
