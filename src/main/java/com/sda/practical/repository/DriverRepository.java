package com.sda.practical.repository;

import com.sda.practical.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    @Query("FROM Driver WHERE license=:license")
    Driver findByDrivingLicense(@Param("license") String license);

}
