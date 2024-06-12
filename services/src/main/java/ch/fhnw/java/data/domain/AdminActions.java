package services.src.main.java.data.domain;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Admin Actions")
public class AdminActions{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "ActionID")
    private Int ActionID;

    @Column(name = "ActionType")
    private Actiontype ActionType;

    @Column(name = "TimeStamp")
    private Timestamp TimeStamp;
}
public AdminActions(Int ActionID,Actiontype ActionType,
    Timestamp TimeStamp) {
    this.ActionID = ActionID;
    this.ActionType = ActionType;
    this.TimeStamp = TimeStamp;
    }
public Int getActionID(){
    return ActionID;
}
public void setActionID(Int ActionID){
    this.ActionID = ActionID
}
public Actiontype getActionType(){
    return ActionType;
}
public void setActionType(Actiontype ActionType){
    this.ActionType = ActionType;
}
public enum Actiontype {
    MODIFY, DELETE, ASSIGN
}
public Timestamp getTimeStamp(){
    return TimeStamp;
}
public void setTimeStamp(Timestamp TimeStamp){
    this.TimeStamp = TimeStamp;
}