package ch.fhnw.pizza.data.domain;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Job Advertisement")
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "JobAdID")
    private int JobAdID;

    @Column(name = "Title")
    private String Title;

    @Column(name = "Description")
    private String Description;

    @Column(name = "ApplicationDeadline")
    private String ApplicationDeadline;

    @Column(name = "ContactInfo")
    private String ContactInfo;

public JobAdvertisement(int JobAdID,String Title,
    String Description,String ApplicationDeadline,String ContactInfo){
    this.JobAdID = JobAdID;
    this.Title = Title;
    this.Description = Description;
    this.ApplicationDeadline = ApplicationDeadline;
    this.ContactInfo = ContactInfo;
}
public int getJobAdID(){
    return JobAdID;
}
public void setJobAdID(int JobAdID){
    this.JobAdID = JobAdID;
}
public String getTitle(){
    return Title;
}
public void setTitle(String Title){
    this.Title = Title;
}
public String getDescription(){
    return Description;
}
public void setDescripton(String Description){
    this.Description = Description;
}
public String getApplicationDeadline(){
    return ApplicationDeadline;
}
public void setApplicationDeadline(String d){
    this.ApplicationDeadline = d;
}
public String getContactInfo(){
    return ContactInfo;
}
public void setContactInfo(String ContactInfo){
    this.ContactInfo = ContactInfo;
    }
}