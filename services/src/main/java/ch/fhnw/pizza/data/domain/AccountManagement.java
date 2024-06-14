package ch.fhnw.pizza.data.domain;

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
    private long ManagementID;

    @Column(name = "ActionType")
    private Actiontype ActionType;

    @Column(name = "TimeStamp")
    private String TimeStamp;

public AccountManagement(long ManagementID,Actiontype ActionType,
    String TimeStamp){
    this.ManagementID = ManagementID;
    this.ActionType = ActionType;
    this.TimeStamp = TimeStamp;
}
public long getManagementID(){
    return ManagementID;
}
public void setManagementID(long ManagementID){
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
public String getTimeStamp(){
    return TimeStamp;
}
public void setTimeStamp(String TimeStamp){
    this.TimeStamp = TimeStamp;
    }
public Object getSomeProperty() {
    throw new UnsupportedOperationException("Unimplemented method 'getSomeProperty'");
}
public void setSomeProperty(Object someProperty) {
    throw new UnsupportedOperationException("Unimplemented method 'setSomeProperty'");
}
}