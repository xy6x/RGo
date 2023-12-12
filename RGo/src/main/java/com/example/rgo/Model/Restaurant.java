package com.example.rgo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Restaurant {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @NotEmpty(message = "please enter Name")
    @Column(columnDefinition = "varchar(100) not null ")
    private String name;
    @NotEmpty(message = "please enter Name")
    @Column(columnDefinition = "varchar(50) not null")
    private String workTime;
    @NotEmpty(message = "please enter Name")
    @Column(columnDefinition = "varchar(150) not null")
    private String location;

}
