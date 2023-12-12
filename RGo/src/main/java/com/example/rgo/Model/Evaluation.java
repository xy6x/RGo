package com.example.rgo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "tat")
public class Evaluation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @NotNull(message = "please enter id user true")
    @Column(columnDefinition = "int not null unique")
    private Integer userId;
    @NotNull(message = "please enter id Restaurant true")
    @Column(columnDefinition = "int not null")
    private Integer restaurantId;
    @NotNull(message = "please enter id order true")
    @Column(columnDefinition = "int not null")
    private Integer orderID;
    @NotNull(message = "please enter number from 1 to 5")
    @Column(columnDefinition ="int(10) check(evan =1 or evan =2 or evan =3 or evan =4 or evan =5)")
    private Integer evan;
    @NotEmpty(message = "please enter message")
    @Column(columnDefinition = "varchar(255) ")
    private String comment;
    private float total;
}
