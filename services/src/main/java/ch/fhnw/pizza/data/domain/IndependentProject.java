package ch.fhnw.pizza.data.domain;

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
    private long ProjectID;

    @Column(name = "ProjectName")
    private String ProjectName;
    
    @Column(name = "Description")
    private String Description;

    @Column(name = "Recurring")
    private Boolean Recurring;

    @Column(name = "StartTime")
    private String StartTime;

    @Column(name = "EndTime")
    private String EndTime;

public IndependentProject(long ProjectID,String ProjectName,
    String Description,Boolean Recurring,String StartTime,String EndTime){
    this.ProjectID = ProjectID;
    this.ProjectName = ProjectName;
    this.Description = Description;
    this.Recurring = Recurring;
    this.StartTime = StartTime;
    this.EndTime = EndTime;  
}
public long getProjectID(){
    return ProjectID;
}
public void setProjectID(long ProjectID){
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
public String getStartTime(){
    return StartTime;
}
public void setStartTime(String d){
    this.StartTime = d;
}
public String getEndTime(){
    return EndTime;
}
public void setEndTime(String d){
    this.EndTime = d;
    }
}