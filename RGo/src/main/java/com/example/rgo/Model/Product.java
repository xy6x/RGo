package com.example.rgo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @NotEmpty(message = "please enter name")
    @Column(columnDefinition = "varchar(50)not null")
    private String name;
    @NotEmpty(message = "please enter classify")
    @Column(columnDefinition = "varchar(10)not null check(classify ='meat' or classify ='chickens')")
    private String classify;
    @Positive
    @NotNull(message = "Please enter the price of the meal")
    @Column(columnDefinition = "int not null")
    private  Integer price;
    @NotNull(message = "please enter id Restaurant true")
    @Column(columnDefinition = "int not null")
    private Integer restaurantId;
    @Column(columnDefinition = "varchar(10) check(rivals ='true' or rivals ='false')")
    private String rivals;
    private LocalTime dateAdded =LocalTime.now();

}
