package com.sda.practical.repository;


import com.sda.practical.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("FROM User WHERE age=:age")
    User findByAge(@Param("age") Long age);

    @Query("FROM User WHERE userName=:username")
    User findUserByUsername(@Param("username") String username);

    @Query("FROM User WHERE email=:email")
    User findUserByEmail(@Param("email") String email);





}
