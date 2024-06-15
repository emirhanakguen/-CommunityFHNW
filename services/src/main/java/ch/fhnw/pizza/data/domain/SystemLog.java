package ch.fhnw.pizza.data.domain;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "System Log")
public class SystemLog{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "LogID")
    private long LogID;

    @Column(name = "TimeStamp")
    private String TimeStamp;

    @Column(name = "Description")
    private String Description;

public SystemLog(long LogID,String TimeStamp,String Description){
    this.LogID = LogID;
    this.TimeStamp = TimeStamp;
    this.Description = Description;
}
public long getLogID(){
    return LogID;
}
public void setLogID(long LogID){
    this.LogID = LogID;
}
public String getTimeStamp(){
    return TimeStamp;
}
public void setTimeStamp(String d){
    this.TimeStamp = d;
}
public String getDescription(){
    return Description;
}
public void setDescription(String Description){
    this.Description = Description;
    }
}
