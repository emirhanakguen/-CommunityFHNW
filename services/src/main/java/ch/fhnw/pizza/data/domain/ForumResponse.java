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
@Table(name = "Forum Response")
public class ForumResponse{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "ResponseID")
    private int ResponseID;

    @Column(name = "Content")
    private String Content;

    @Column(name = "ResponseTime")
    private String ResponseTime;

public ForumResponse(int ResponseID,String Content,
    String ResponseTime){
    this.ResponseID = ResponseID;
    this.Content = Content;
    this.ResponseTime = ResponseTime;
}
public int getResponseID(){
    return ResponseID;
}
public void setResponseID(int ResponseID){
    this.ResponseID = ResponseID;
}
public String getContent(){
    return Content;
}
public void setContent(String Content){
    this.Content = Content;
}
public String getResponseTime(){
    return ResponseTime;
}
public void setResponseTime(String d){
    this.ResponseTime = d;
    }
public void setPostId(Long postId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setPostId'");
}
} 