package com.gl.tms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Profile;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id",unique = true,nullable = false)
    private Long userId;


    @Column(nullable = false)
    private String userName;

    @Column(nullable = false,unique = true)
    private String password;


    @Column(unique = true, nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="profile_id")
    private UserProfile userProfile;

}
