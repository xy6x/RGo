package com.example.rgo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class MyUser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @NotEmpty(message = "please enter UserName")
    @Column(columnDefinition = "varchar(100) not null unique ")
    private String userName;
    @NotEmpty(message = "please enter phoneNumber")
    @Column(columnDefinition = "varchar(50) not null unique ")
    private String phoneNumber;
    @Email
    @NotEmpty(message = "please enter Email")
    @Column(columnDefinition = "varchar(70) not null unique ")
    private String email;
    @NotEmpty(message = "please enter password")
    @Column(columnDefinition = "varchar(50) not null ")
    private String password;
}
