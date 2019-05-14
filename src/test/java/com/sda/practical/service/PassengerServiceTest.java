package com.sda.practical.service;


import com.sda.practical.model.Passenger;
import com.sda.practical.service.Imp.PassengerServiceImp;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
//@Sql(scripts = "/test-dataset.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)

public class PassengerServiceTest {

    @Autowired
    PassengerServiceImp passengerServiceImp;


    @Test
    public void passengerBlockTest(){
        Passenger passenger = passengerServiceImp.isBlocked(1L);
        Assert.assertFalse(passenger.getActive());

    }

    @Test
    public void passengerUnblockTest(){
        Passenger passenger = passengerServiceImp.Blocked(1L);
        Assert.assertTrue(passenger.getActive());

    }

}
