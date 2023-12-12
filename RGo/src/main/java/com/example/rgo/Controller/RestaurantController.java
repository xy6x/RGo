package com.example.rgo.Controller;

import com.example.rgo.Model.Restaurant;
import com.example.rgo.Service.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/res")
public class RestaurantController {
    private final RestaurantService restaurantService;
    @GetMapping("/get")
    public ResponseEntity getAllRestaurant(){
        return  ResponseEntity.status(HttpStatus.OK).body(restaurantService.getAllRestaurant());
    }
    @PostMapping("/add")
    public ResponseEntity addRestaurant(@RequestBody @Valid Restaurant restaurant , Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        restaurantService.addRestaurant(restaurant);
        return ResponseEntity.status(HttpStatus.OK).body("added Restaurant");
    }
    @PutMapping("/put/{id}")
    public ResponseEntity updateRestaurant(@PathVariable Integer id,@RequestBody @Valid Restaurant restaurant,Errors errors){
        if (errors.hasErrors() ) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        restaurantService.updateRestaurant(id, restaurant);
        return ResponseEntity.status(HttpStatus.OK).body("Update Restaurant");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteRestaurant(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(restaurantService.deleteRestaurant(id));
    }
    @GetMapping("/check/{name}")
public ResponseEntity location(@PathVariable String name){
        Restaurant restaurant=restaurantService.locationUn(name);
        return ResponseEntity.status(HttpStatus.OK).body(restaurant);
}

}
