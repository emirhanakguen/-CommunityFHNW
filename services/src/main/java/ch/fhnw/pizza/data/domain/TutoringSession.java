package ch.fhnw.pizza.data.domain;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tutoring Session")
public class TutoringSession{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "SessionID")
    private long SessionID;

    @Column(name = "Subject")
    private String Subject;

    @Column(name = "Description")
    private String Description;

    @Column(name = "Recurring")
    private Boolean Recurring;

    @Column(name = "StartTime")
    private String StartTime;

    @Column(name = "EndTime")
    private String EndTime;

    @Column(name = "Status")
    private SessionStatus Status;

public TutoringSession(long SessionID,String Subject,
    String Description,Boolean Recurring,String StartTime,
    String EndTime,SessionStatus Status){
    this.SessionID = SessionID;
    this.Subject = Subject;
    this.Description = Description;
    this.Recurring = Recurring;
    this.StartTime = StartTime;
    this.EndTime = EndTime;
    this.Status = Status;
}
public long getSessionID(){
        return SessionID;
}
public void setSessionID(long SessionID){
    this.SessionID = SessionID;
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
    return Recurring;
}
public void setRecurring(Boolean Recurring){
    this.Recurring = Recurring;
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
public SessionStatus getStatus(){
    return Status;
}
public void setStatus(SessionStatus Status){
    this.Status = Status;
}
public enum SessionStatus {
    ACTIVE, COMPLETED, CANCELLED
    }
}
