package services.src.main.java.data.domain;

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
    private Int ManagementID;

    @Column(name = "ActionType")
    private Actiontype ActionType;

    @Column(name = "TimeStamp")
    private Timestamp TimeStamp;

}
public AccountManagement(Int ManagementID,Actiontype ActionType,
    Timestamp TimeStamp){
    this.ManagementID = ManagementID;
    this.ActionType = ActionType;
    this.TimeStamp = TimeStamp;
}
public Int getManagementID(){
    return ManagementID;
}
public void setManagementID(Int ManagementID){
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