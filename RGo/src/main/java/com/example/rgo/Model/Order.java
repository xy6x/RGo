package com.example.rgo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Table(name = "myOlder")
public class Order{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @NotNull(message = "please enter id user true")
    @Column(columnDefinition = "int not null")
    private Integer userId;
    @NotNull(message = "please enter id Restaurant true")
    @Column(columnDefinition = "int not null")
    private Integer restaurantId;
    @NotNull(message = "please enter id product true")
    @Column(columnDefinition = "int not null")
    private Integer productId;
    @NotNull(message = "please enter quantity")
    @Column(columnDefinition = "int not null")
    private Integer quantity =0;
    private Integer total;

}
