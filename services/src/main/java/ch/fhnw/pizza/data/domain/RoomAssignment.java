package ch.fhnw.pizza.data.domain;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Room Assignment")
public class RoomAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "RoomID")
    private long RoomID;

    @Column(name = "Building")
    private String Building;

    @Column(name = "Capacity")
    private int Capacity;

    @Column(name = "Resources")
    private String Resources;

    @Column(name = "StartTime")
    private String StartTime;

    @Column(name = "EndTime")
    private String EndTime;

public RoomAssignment(long RoomID,String Building,int Capacity,
    String Resources,String StartTime,String EndTime){
        this.RoomID = RoomID;
        this.Building = Building;
        this.Capacity = Capacity;
        this.Resources = Resources;
        this.StartTime = StartTime;
        this.EndTime = EndTime;
}
public long getRoomID(){
    return RoomID;
}
public void setRoomID(long RoomID){
    this.RoomID = RoomID;
}
public String getBuilding(){
    return Building;
}
public void setBuilding(String Building){
    this.Building = Building;
}
public int getCapacity(){
    return Capacity;
}
public void setCapacity(int Capacity){
    this.Capacity = Capacity;
}
public String getResources(){
    return Resources;
}
public void setResources(String Resources){
    this.Resources = Resources;
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