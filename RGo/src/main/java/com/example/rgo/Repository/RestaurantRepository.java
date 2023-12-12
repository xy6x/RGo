package com.example.rgo.Repository;

import com.example.rgo.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
    Restaurant findRestaurantById(Integer id);
    Restaurant findRestaurantByLocation(String mes);
}
