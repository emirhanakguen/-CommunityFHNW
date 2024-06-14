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
@Table(name = "Account Management")
public class AccountManagement{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "ManagementID")
    private int ManagementID;

    @Column(name = "ActionType")
    private Actiontype ActionType;

    @Column(name = "TimeStamp")
    private Timestamp TimeStamp;

public AccountManagement(int ManagementID,Actiontype ActionType,
    Timestamp TimeStamp){
    this.ManagementID = ManagementID;
    this.ActionType = ActionType;
    this.TimeStamp = TimeStamp;
}
public int getManagementID(){
    return ManagementID;
}
public void setManagementID(int ManagementID){
    this.ManagementID = ManagementID;
}
public Actiontype getActionType(){
    return ActionType;
}
public void setActionType(Actiontype ActionType){
    this.ActionType = ActionType;
}
    public enum Actiontype {
        CREATE, MODIFY, DELETE
}
public Timestamp getTimeStamp(){
    return TimeStamp;
}
public void setTimeStamp(Timestamp TimeStamp){
    this.TimeStamp = TimeStamp;
    }
public Object getSomeProperty() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getSomeProperty'");
}
public void setSomeProperty(Object someProperty) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setSomeProperty'");
}
}