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
@Table(name = "Admin Actions")
public class AdminActions{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "ActionID")
    private int ActionID;

    @Column(name = "ActionType")
    private Actiontype ActionType;

    @Column(name = "TimeStamp")
    private Timestamp TimeStamp;

public AdminActions(int ActionID,Actiontype ActionType,
    Timestamp TimeStamp) {
    this.ActionID = ActionID;
    this.ActionType = ActionType;
    this.TimeStamp = TimeStamp;
    }
public int getActionID(){
    return ActionID;
}
public void setActionID(int ActionID){
    this.ActionID = ActionID;
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
public void setType(String type) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setType'");
}
}