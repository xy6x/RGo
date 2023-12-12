package com.example.rgo.Service;
import com.example.rgo.ApiException.ApiException;
import com.example.rgo.Model.MyUser;
import com.example.rgo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<MyUser> getAllUser(){

        return userRepository.findAll();
    }
    public void addUser(MyUser myUser){
        userRepository.save(myUser);
    }
    public MyUser updateUser(Integer id,MyUser myUser){
        MyUser oldUser=userRepository.findMyUserById(id);
        oldUser.setUserName(myUser.getUserName());
        oldUser.setPhoneNumber(myUser.getPhoneNumber());
        oldUser.setEmail(myUser.getEmail());
        oldUser.setPassword(myUser.getPassword());
        return userRepository.save(oldUser);
    }
    public MyUser deleteUser(Integer id){
        MyUser myUser=userRepository.findMyUserById(id);
        userRepository.delete(myUser);
        return myUser;
    }
    public List<MyUser> searchAllUser(Integer id){
        List<MyUser> myUsers=userRepository.id(id);
        return myUsers;
    }
    public MyUser check(String number){
        MyUser myUser=userRepository.findMyUserByPhoneNumber(number);
        return myUser;
    }
    public MyUser reternEmail(String email){
        MyUser myUser=userRepository.findMyUserByEmail(email);
        if (myUser == null) {
            throw new ApiException("the email is not here");
        }
        return myUser;
    }
    public MyUser checkUserName(String user){
        MyUser myUser=userRepository.findMyUserByUserName(user);
        if (myUser == null) {
            throw new ApiException("the User Name  is not here");
        }
        return myUser;
    }




}
