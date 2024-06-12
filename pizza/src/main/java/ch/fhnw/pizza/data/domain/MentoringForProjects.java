package services.src.main.java.data.domain;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Mentoring for Projects")
public class MentoringForProjects{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "ProjectID")
    private Int ProjectID;

    @Column(name = "Subject")
    private String Subject;

    @Column(name = "Description")
    private String Description;

    @Column(name = "Reccuring")
    private Boolean Recurring;

    @Column(name = "ProjectName")
    private String ProjectName;

    @Column(name = "StartTime")
    private Timestamp StartTime;

    @Column(name = "EndTime")
    private Timestamp EndTime;

}
public MentoringForProjects(Int ProjectID,String Subject,
    String Description,Boolen Reccuring,String ProjectName,
    Timestamp StartTime,Timestamp EndTime){
    this.ProjectID = ProjectID;
    this.Subject = Subject;
    this.Description = Description;
    this.Reccuring = Reccuring;
    this.ProjectName = ProjectName;
    this.StartTime = StartTime;
    this.EndTime = EndTime;
}
public Int getProjectID(){
    return ProjectID;
}
public void setProjectID(Int ProjectID){
    this.ProjectID = ProjectID;
}
public String getSubject(){
    return Subject;
}
public void setSubject(String Subject){
    this.Subject = Subject;
}
public String getDescription(){
    return Description;
}
public void setDescription(String Description){
    this.Description = Description;
}
public Boolean getReccuring(){
    return Reccuring;
}
public void setRecurring(Boolean Reccuring){
    this.Reccuring = Reccuring;
}
public String getProjectName(){
    return ProjectName;
}
public void setProjectName(String ProjectName){
    this.ProjectName = ProjectName;
}
public Timestamp getStartTime(){
    return StartTime;
}
public void setStartTime(Timestamp StartTime){
    this.StartTime = StartTime;
}
public Timestamp getEndTime(){
    return EndTime;
}
public void setEndTime(Timestamp EndTime){
    this.EndTime = EndTime;
}