package ch.fhnw.pizza.data.domain;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Buddy System")
public class BuddySystem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "BuddyPairID")
    private long BuddyPairID;

    @Column(name = "Languages")
    private String Languages;

    @Column(name = "Status")
    private BuddyStatus Status;

public BuddySystem(long BuddyPairID,String Languages,
    BuddyStatus Status){
    this.BuddyPairID = BuddyPairID;
    this.Languages = Languages;
    this.Status = Status;
}
public long getBuddyPairID(){
    return BuddyPairID;
}
public void setBuddyPairID(long BuddyPairID){
    this.BuddyPairID = BuddyPairID;
}
public String getLanguages(){
    return Languages;
}
public void setLanguages(String Languages){
    this.Languages = Languages;
}
public BuddyStatus getStatus(){
    return Status;
}
public void setStatus(BuddyStatus Status){
    this.Status = Status;
}
public enum BuddyStatus {
    ACTIVE, COMPLETED
    }
}