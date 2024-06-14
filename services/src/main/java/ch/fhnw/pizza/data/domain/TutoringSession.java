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
@Table(name = "Tutoring Session")
public class TutoringSession{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "SessionID")
    private int SessionID;

    @Column(name = "Subject")
    private String Subject;

    @Column(name = "Description")
    private String Description;

    @Column(name = "Recurring")
    private Boolean Recurring;

    @Column(name = "StartTime")
    private Timestamp StartTime;

    @Column(name = "EndTime")
    private Timestamp EndTime;

    @Column(name = "Status")
    private SessionStatus Status;

public TutoringSession(int SessionID,String Subject,
    String Description,Boolean Recurring,Timestamp StartTime,
    Timestamp EndTime,SessionStatus Status){
    this.SessionID = SessionID;
    this.Subject = Subject;
    this.Description = Description;
    this.Recurring = Recurring;
    this.StartTime = StartTime;
    this.EndTime = EndTime;
    this.Status = Status;
}
public int getSessionID(){
        return SessionID;
}
public void setSessionID(int SessionID){
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
public void setRecurring(Boolean Reccuring){
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
