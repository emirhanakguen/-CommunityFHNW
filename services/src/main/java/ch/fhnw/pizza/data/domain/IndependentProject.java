package ch.fhnw.pizza.data.domain;

import java.security.Timestamp;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Independent Project")
public class IndependentProject{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "ProjectID")
    private int ProjectID;

    @Column(name = "ProjectName")
    private String ProjectName;
    
    @Column(name = "Description")
    private String Description;

    @Column(name = "Recurring")
    private Boolean Recurring;

    @Column(name = "StartTime")
    private Timestamp StartTime;

    @Column(name = "EndTime")
    private Timestamp EndTime;

public IndependentProject(int ProjectID,String ProjectName,
    String Description,Boolean Recurring,Timestamp StartTime,Timestamp EndTime){
    this.ProjectID = ProjectID;
    this.ProjectName = ProjectName;
    this.Description = Description;
    this.Recurring = Recurring;
    this.StartTime = StartTime;
    this.EndTime = EndTime;  
}
public int getProjectID(){
    return ProjectID;
}
public void setProjectID(int ProjectID){
    this.ProjectID = ProjectID;
}
public String getProjectName(){
    return ProjectName;
}
public void setProjectName(String ProjectName){
    this.ProjectName = ProjectName;
}
public String getDescription(){
    return Description;
}
public void setDescription(String Description){
    this.Description = Description;
}
public Boolean getReccuring(){
    return Recurring;
}
public void setReccuring(Boolean Reccuring){
    this.Recurring = Reccuring;
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
}