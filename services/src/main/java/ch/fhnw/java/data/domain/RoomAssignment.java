package services.src.main.java.data.domain;

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
    private Int RoomID;

    @Column(name = "Building")
    private String Building;

    @Column(name = "Capacity")
    private Int Capacity;

    @Column(name = "Resources")
    private String Resources;

    @Column(name = "StartTime")
    private Timestamp StartTime;

    @Column(name = "EndTime")
    private Timestamp EndTime;

}
public RoomAssignment(Int RoomID,String Building,Int Capacity,
    String Resources,Timestamp StartTime,Timestamp EndTime){
        this.RoomID = RoomID;
        this.Building = Building;
        this.Capacity = Capacity;
        this.Resources = Resources;
        this.StartTime = StartTime;
        this.EndTime = EndTime;
}
public Int getRoomID(){
    return RoomID;
}
public void setRoomID(Int RoomID){
    this.RoomID = RoomID;
}
public String getBuilding(){
    return Building;
}
public void setBuilding(String Building){
    this.Building = Building;
}
public Int getCapacity(){
    return Capacity;
}
public void setCapacity(Int Capacity){
    this.Capacity = Capacity;
}
public String getResources(){
    return Resources;
}
public void setResources(String Resources){
    this.Resources = Resources;
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