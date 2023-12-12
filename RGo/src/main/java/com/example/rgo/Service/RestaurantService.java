package com.example.rgo.Service;

import com.example.rgo.ApiException.ApiException;
import com.example.rgo.Model.MyUser;
import com.example.rgo.Model.Restaurant;
import com.example.rgo.Repository.RestaurantRepository;
import com.example.rgo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;
    public List<Restaurant> getAllRestaurant(){

       return restaurantRepository.findAll();
    }
    public void addRestaurant(Restaurant restaurant){
        restaurantRepository.save(restaurant);
    }
    public void  updateRestaurant(Integer id,Restaurant restaurant){
        Restaurant OldRestaurant =restaurantRepository.findRestaurantById(id);
        if (OldRestaurant == null) {
            throw new ApiException("the restaurant not found");
        }
        OldRestaurant.setName(restaurant.getName());
        OldRestaurant.setWorkTime(restaurant.getWorkTime());
        OldRestaurant.setLocation(restaurant.getLocation());
        restaurantRepository.save(OldRestaurant);
    }
    public Restaurant  deleteRestaurant(Integer id) {
        Restaurant deRestaurant = restaurantRepository.findRestaurantById(id);
        if (deRestaurant == null) {
            throw new ApiException("the restaurant not found");
        }
        restaurantRepository.delete(deRestaurant);
        return deRestaurant;
    }
    public Restaurant locationUn(String set){
        Restaurant restaurant =restaurantRepository.findRestaurantByLocation(set);
        if (restaurant == null) {
            throw new ApiException("not the location");

        }
        return restaurant;
    }
}
