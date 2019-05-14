package com.sda.practical.repository;

import com.sda.practical.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    @Query("FROM Passenger WHERE mobile=:mobile")
    Passenger findByMobileNumber(@Param("mobile") String mobile);
}
