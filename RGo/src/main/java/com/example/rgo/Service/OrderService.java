package com.example.rgo.Service;

import com.example.rgo.ApiException.ApiException;
import com.example.rgo.Model.MyUser;
import com.example.rgo.Model.Order;
import com.example.rgo.Model.Product;
import com.example.rgo.Model.Restaurant;
import com.example.rgo.Repository.OrderRepository;
import com.example.rgo.Repository.ProductRepository;
import com.example.rgo.Repository.RestaurantRepository;
import com.example.rgo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final ProductRepository productRepository;

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public void addOrder(Order order) {
        MyUser user = userRepository.findMyUserById(order.getUserId());
        if (user == null) {
            throw new ApiException("The user not Found");
        }
        Restaurant restaurant = restaurantRepository.findRestaurantById(order.getRestaurantId());
        if (restaurant == null) {
            throw new ApiException("The Restaurant not Found");
        }
        Product product = productRepository.findProductById(order.getProductId());
        if (product == null) {
            throw new ApiException("The Product not Found");
        }
        if (order.getQuantity()>=1) {
            order.setTotal(order.getQuantity()*product.getPrice());
        }


        orderRepository.save(order);
    }

    public void updateOrder(Integer id,Order order){
        Order oldOrder =orderRepository.findOrderById(id);
        if (oldOrder == null) {
            throw new ApiException("The Order not Found");
        }
        oldOrder.setProductId(order.getProductId());
        oldOrder.setQuantity(order.getQuantity());
        orderRepository.save(oldOrder);
    }
    public Order deleteOrder(Integer id){
        Order order=orderRepository.findOrderById(id);
        if (order == null) {
            throw new ApiException("The Order not Found");
        }

        orderRepository.delete(order);
        return order;
    }
    public Order rival(Integer number){
        Order ord =orderRepository.findOrderById(number);

        if (ord.getQuantity()>=2) {
            ord.setTotal(ord.getTotal()/10*9);

        }
        orderRepository.save(ord);
        return ord;
    }
    public Integer checkUser(Integer id) {
//        List<Order> myUser =orderRepository.findOrderByUserId(id);
        Integer totals =orderRepository.findOrderByProductId(id);
//        if (myUser == null) {
//            throw new ApiException("the User not older");
//        }
//
//        Integer num =0;
//        for (int i = 0; i <productRepository.findAll().size() ; i++) {
//         num+=productRepository.findAll().get(i).getPrice()*myUser.get(i).getQuantity();
//           myUser.get(i).setTotal(num);
return  totals;
        }
//        Integer num = 0;
//        for (Order o:myUser) {
//           o.setTotal(num+=o.getTotal());
//           myUser.add(o);
//        }


//    }

    public Order don(Integer id){
        Order order =orderRepository.id(id);
        Product product=productRepository.findProductById(order.getProductId());
        if (order.getQuantity()*product.getPrice()>=100){

            order.setTotal(product.getPrice()*order.getQuantity()/10*8);
        }
        return order;
    }
    public Order coupon(Integer id,Integer id2){
        Order order =orderRepository.findOrderById(id);
        Product product=productRepository.findProductById(id2);
        if (order.getId().equals(id2)&&product.getRivals().equals("true")) {
             order.setTotal(product.getPrice()*order.getQuantity()/10*7);

        }
        return order;
    }



}
