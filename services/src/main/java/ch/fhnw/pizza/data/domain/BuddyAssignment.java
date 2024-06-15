package ch.fhnw.pizza.data.domain;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Buddy Assignment")
public class BuddyAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "AdminID")
    private long AdminID;

    @Column(name = "internationalstudentId")
    private String internationalstudentId;

    @Column(name = "buddyId")
    private int buddyId;

public BuddyAssignment(long AdminID,String internationalstudentId,
    int buddyId) {
    this.AdminID = AdminID;
    this.internationalstudentId = internationalstudentId;
    this.buddyId = buddyId;
    }
public long getAdminID(){
    return AdminID;
}
public void setAdminID(long AdminID){
    this.AdminID = AdminID;
}
public String getinternationalstudentId(){
    return internationalstudentId;
}
public void setinternationalstudentId(String internationalstudentId){
    this.internationalstudentId = internationalstudentId;
}
public int getbuddyId(){
    return buddyId;
}
public void setbuddyId(int buddyId){
    this.buddyId = buddyId;
    }
    
}