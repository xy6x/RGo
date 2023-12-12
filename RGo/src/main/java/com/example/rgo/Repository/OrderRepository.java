package com.example.rgo.Repository;

import com.example.rgo.Model.MyUser;
import com.example.rgo.Model.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    Order findOrderById(Integer id);

    Order findOrderByQuantity(Integer number);
    List<Order> findOrderByUserId(Integer id);
    @Query("select e from Order e where e.userId=?1")
    Order id(Integer id);
    @Query("select sum(e.total) from Order e ")
    Integer findOrderByProductId(Integer id);

}
