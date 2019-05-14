package com.sda.practical.repository;

import com.sda.practical.dto.UserDto;
import com.sda.practical.model.Driver;
import com.sda.practical.model.Passenger;
import com.sda.practical.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AdminRepository extends JpaRepository<User,Long> {

    @Query(
            value = "SELECT * FROM User u WHERE u.role_id = 4",
            nativeQuery = true)
    List<User> ListOfDrivers();

    @Query(
            value = "SELECT * FROM User u WHERE u.role_id = 1",
            nativeQuery = true)
    List<User> ListOfPassengers();

}
