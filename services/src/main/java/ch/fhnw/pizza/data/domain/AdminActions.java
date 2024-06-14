package ch.fhnw.pizza.data.domain;

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
    private long ActionID;

    @Column(name = "ActionType")
    private Actiontype ActionType;

    @Column(name = "TimeStamp")
    private String TimeStamp;

public AdminActions(long ActionID,Actiontype ActionType,
    String TimeStamp) {
    this.ActionID = ActionID;
    this.ActionType = ActionType;
    this.TimeStamp = TimeStamp;
    }
public long getActionID(){
    return ActionID;
}
public void setActionID(long ActionID){
    this.ActionID = ActionID;
}
public Actiontype getActionType(){
    return ActionType;
}
public void setActionType(ch.fhnw.pizza.data.domain.AdminActions.Actiontype delete){
    this.ActionType = delete;
}
public enum Actiontype {
    MODIFY, DELETE, ASSIGN
}
public String getTimeStamp(){
    return TimeStamp;
}
public void setTimeStamp(String TimeStamp){
    this.TimeStamp = TimeStamp;
    }
public void setType(String type) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setType'");
}
}