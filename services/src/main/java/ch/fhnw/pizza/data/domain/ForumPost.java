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
@Table(name = "Forum Post")
public class ForumPost{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "PostID")
    private int PostID;

    @Column(name = "Content")
    private String Content;

    @Column(name = "Topic")
    private String Topic;

    @Column(name = "CreationTime")
    private Timestamp CreationTime;

public ForumPost(int PostID,String Content,String Topic,
    Timestamp CreationTime){
    this.PostID = PostID;
    this.Content = Content;
    this.Topic = Topic;
    this.CreationTime = CreationTime;
}
public int getPostID(){
    return PostID;
}
public void setPostID(int PostID){
    this.PostID = PostID;
}
public String getContent(){
    return Content;
}
public void setContent(String Content){
    this.Content = Content;
}
public String getTopic(){
    return Topic;
}
public void setTopic(String Topic){
    this.Topic = Topic;
}
public Timestamp getCreationTime(){
    return CreationTime;
}
public void setCreationTime(Timestamp CreationTime){
    this.CreationTime = CreationTime;
    }
}