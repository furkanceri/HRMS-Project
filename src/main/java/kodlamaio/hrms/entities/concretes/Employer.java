package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "companies")
@PrimaryKeyJoinColumn(name = "company_id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisement"})
public class Employer extends User{

    @NotNull
    @NotBlank
    @Column(name = "company_name")
    private String companyName;

    @NotNull
    @NotBlank
    @Column(name = "web_site")
    private String webSite;

    @NotNull
    @NotBlank
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> JobAdvertisement;

    @OneToOne(mappedBy = "employer", cascade = CascadeType.ALL)
    private CvExperience cvExperience;

    public Employer(int id, String email, String password, String companyName, String webSite, String phoneNumber){

        super(id,email,password);
        this.companyName=companyName;
        this.phoneNumber=phoneNumber;
        this.webSite=webSite;
    }
}
