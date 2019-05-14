package com.sda.practical.service;



import com.sda.practical.model.Driver;
import com.sda.practical.service.Imp.DriverServiceImp;
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
public class DriverServiceTest {


    @Autowired
    DriverServiceImp driverService;

    //when
    @Test
    public void blockTestSuccess(){
       Driver driver= driverService.deActive(1L);
        Assert.assertFalse(driver.getActive());

    }

    @Test
    public void activeTestSuccess(){
        Driver driver = driverService.isActive(1L);
        Assert.assertTrue(driver.getActive());
    }




}
