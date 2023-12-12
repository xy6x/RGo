package com.example.rgo.Repository;

import com.example.rgo.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<MyUser,Integer> {
    MyUser findMyUserById(Integer id);

    @Query("select e from MyUser e where e.id=?1")
     List<MyUser> id(Integer id);
    MyUser findMyUserByPhoneNumber(String number);
    MyUser findMyUserByEmail(String email);
    MyUser findMyUserByUserName(String user);


}
