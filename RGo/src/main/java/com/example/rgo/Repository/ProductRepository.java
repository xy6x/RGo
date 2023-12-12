package com.example.rgo.Repository;

import com.example.rgo.Model.Product;
import lombok.Data;
import org.apache.tomcat.util.http.ConcurrentDateFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
@Repository

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findProductById(Integer id);

    Product findProductByPrice(Integer price);

@Query("SELECT  e from Product e where  e.restaurantId=?1 and  e.price<?2")
    List<Product> findProductByOffer(Integer rest,Integer price);
    @Query("SELECT  e from Product e where  e.restaurantId=?1 and  e.classify=?2")
    List<Product> findProductByClassify(Integer rest,String name);
    @Query("SELECT e from Product e where e.dateAdded between ?1 and ?2")
    List<Product> findByStartDateBetween(LocalTime localTime, LocalTime date);
}

