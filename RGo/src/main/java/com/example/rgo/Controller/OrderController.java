package com.example.rgo.Controller;

import com.example.rgo.Model.Order;
import com.example.rgo.Service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;
    @GetMapping("/get")
    public List<Order> getAllOrder(){
        return orderService.getAllOrder();
    }
    @PostMapping("/add")
    public ResponseEntity addOlder(@RequestBody @Valid Order order, Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        orderService.addOrder(order);
        return ResponseEntity.status(HttpStatus.OK).body("add Older");
    }
    @PutMapping("/put/{id}")
    public ResponseEntity updateOlder(@PathVariable Integer id, @RequestBody @Valid Order order, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        orderService.updateOrder(id, order);
        return ResponseEntity.status(HttpStatus.OK).body("Update Older");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOlder(@PathVariable Integer id) {
return ResponseEntity.status(HttpStatus.OK).body(orderService.deleteOrder(id));
    }
    @PutMapping("/rival/{id}")
    public ResponseEntity rival(@PathVariable Integer id){
        Order ord =orderService.rival(id);
        return ResponseEntity.status(HttpStatus.OK).body(ord);

    }
//    @PutMapping("/total/{id}")
//    public ResponseEntity total(@PathVariable Integer id){
//        Order ord =orderService.totals(id);
//        return ResponseEntity.status(HttpStatus.OK).body(ord);
//    }
    @GetMapping("/don/{id}")
    public ResponseEntity don(@PathVariable Integer id){
        Order ord =orderService.don(id);
        return ResponseEntity.status(HttpStatus.OK).body(ord);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity user(@PathVariable Integer id){
       Integer users =orderService.checkUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
    @GetMapping("/dsTotal/{id}/{id2}")
    public ResponseEntity desTotal(@PathVariable Integer id,@PathVariable Integer id2){
        Order order =orderService.coupon(id, id2);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }


    }
