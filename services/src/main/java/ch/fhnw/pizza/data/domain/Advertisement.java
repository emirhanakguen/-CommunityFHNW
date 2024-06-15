package ch.fhnw.pizza.data.domain;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
    
@Entity
@Table(name = "Advertisement")
public class Advertisement{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Hidden
        @Column(name = "adminID")
        private long adminId;
    
        @Column(name = "title")
        private String title;
    
        @Column(name = "content")
        private String content;
    
    public Advertisement(long adminId,String title,
        String content){
        this.adminId = adminId;
        this.title = title;
        this.content = content;
    }
    public long getadminId(){
        return adminId;
    }
    public void setadminId(long adminId){
        this.adminId = adminId;
    }
    public String gettitle(){
        return title;
    }
    public void settitle(String title){
        this.title = title;
    }
    public String getcontent(){
        return content;
    }
    public void setcontent(String content){
        this.content = content;
    }
}