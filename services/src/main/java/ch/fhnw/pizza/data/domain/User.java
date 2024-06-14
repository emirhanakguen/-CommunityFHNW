package ch.fhnw.pizza.data.domain;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "UserID")
    private long UserID;

    @Column(name = "Username")
    private String Username;

    @Column(name = "Password")
    private String Password;

    @Column(name = "Role")
    private UserRole Role;

    @Column(name = "Email")
    private String Email;

    @Column(name = "PhoneNumber")
    private String PhoneNumber;

public User(long UserID,String Username,String Password,
    UserRole Role,String Email,String PhoneNumber){
    this.UserID = UserID;
    this.Username = Username;
    this.Password = Password;
    this.Role = Role;
    this.Email = Email;
    this.PhoneNumber = PhoneNumber;
}
public long getUserID(){
    return UserID;
}
public void setUserID(long UserID){
    this.UserID = UserID;
}
public String getUsername(){
    return Username;
}
public void setUsername(String Username){
    this.Username = Username;
}
public String getPassword(){
    return Password;
}
public void setPassword(String Password){
    this.Password = Password;
}
public UserRole getRole(){
    return Role;
}
public void setRole(UserRole Role){
    this.Role = Role;
}
public enum UserRole {
    STUDENT, ADMIN, SUPER_ADMIN
}
public String getEmail(){
    return Email;
}
public void setEmail(String Email){
    this.Email = Email;
}
public String getPhoneNumber(){
    return PhoneNumber;
}
public void setPhoneNumber(String PhoneNumber){
    this.PhoneNumber = PhoneNumber;
    }
public Long getId(int userID2) {
    throw new UnsupportedOperationException("Unimplemented method 'getId'");
}
public Object getSomeProperty() {
    throw new UnsupportedOperationException("Unimplemented method 'getSomeProperty'");
}
public void setSomeProperty(Object someProperty) {
    throw new UnsupportedOperationException("Unimplemented method 'setSomeProperty'");
}
public boolean isPresent() {
    throw new UnsupportedOperationException("Unimplemented method 'isPresent'");
}
public User get() {
    throw new UnsupportedOperationException("Unimplemented method 'get'");
}
}