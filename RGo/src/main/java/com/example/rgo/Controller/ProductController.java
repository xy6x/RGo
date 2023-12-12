package com.example.rgo.Controller;

import com.example.rgo.Model.Product;
import com.example.rgo.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;
    @GetMapping("/get")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }
    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody @Valid Product product, Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.OK).body("added Product");
    }
    @PutMapping("/put/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id , @RequestBody @Valid Product product, Errors errors) {
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        productService.updateProduct(id, product);
        return ResponseEntity.status(HttpStatus.OK).body("Update Product");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProduct(id));
    }
    @GetMapping("/offer/{res}/{price}")
    public ResponseEntity searchOffer(@PathVariable Integer price,@PathVariable Integer res){
        return ResponseEntity.status(HttpStatus.OK).body(productService.searchTheOffer(res,price));

    }
    @GetMapping("/search/{id}/{classify}")
    public ResponseEntity searchClassify(@PathVariable Integer id,@PathVariable String classify){
        return ResponseEntity.status(HttpStatus.OK).body(productService.listOfClassify(id,classify));
    }
    @GetMapping("/check/{localTime}/{loc}")
    public ResponseEntity ourNews(@PathVariable LocalTime localTime,@PathVariable LocalTime loc){
        return ResponseEntity.status(HttpStatus.OK).body(productService.ourNews(localTime,loc));
    }



}
