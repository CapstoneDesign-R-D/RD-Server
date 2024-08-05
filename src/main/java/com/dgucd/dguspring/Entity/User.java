package com.dgucd.dguspring.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
public class User {
    @Id
    //@GeneratedValue
    @Column(name = "userEmail")
    private String userEmail;
    @Column(name = "userName")
    private String userName;

    @Builder
    public User(String userEmail, String userName){
        this.userEmail=userEmail;
        this.userName=userName;
    }

    protected User(){

    }
}
