package com.example.rgo.Service;

import com.example.rgo.ApiException.ApiException;
import com.example.rgo.Model.Product;
import com.example.rgo.Model.Restaurant;
import com.example.rgo.Repository.ProductRepository;
import com.example.rgo.Repository.RestaurantRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private  final ProductRepository productRepository;
    private final RestaurantRepository restaurantRepository;
    public List<Product> getAllProduct(){
return productRepository.findAll();
    }
    public void addProduct(Product product){
        Restaurant restaurant=restaurantRepository.findRestaurantById(product.getRestaurantId());
        if (restaurant == null) {
            throw new ApiException("the Restaurant not found");
        }
        productRepository.save(product);
    }
    public void updateProduct(Integer id ,Product product){
        Product oldProduct =productRepository.findProductById(id);
        if (oldProduct == null) {
            throw new ApiException("the Product not found");
        }
        oldProduct.setName(product.getName());
        oldProduct.setClassify(product.getClassify());
        oldProduct.setPrice(product.getPrice());

    }
    public Product deleteProduct(Integer id){
        Product product =productRepository.findProductById(id);
        if (product == null) {
            throw new ApiException("The Product not found");

        }
        productRepository.delete(product);
        return product;
    }
    public List<Product> searchTheOffer(Integer res,Integer price){
        List<Product> products =productRepository.findProductByOffer(res,price);
        if (products == null) {
            throw new ApiException("new not offer");

        }
        return products;
    }
    public List<Product> listOfClassify(Integer id,String name){
        List<Product> pro =productRepository.findProductByClassify(id,name);
        if (pro == null) {
            throw new ApiException("please enter classify ='meat' or classify ='chickens'");
        }
        return pro;
    }
    public List<Product> ourNews(LocalTime localTime ,LocalTime loc){
        List<Product> products =productRepository.findByStartDateBetween(localTime,loc);
        if (products == null) {
            throw new ApiException("the date not ourNew");

        }
        return products;
    }



}
