package com.sda.practical.service;

import com.sda.practical.order.OrderDto.OrderDto;
import com.sda.practical.order.application.service.OrderImp.OrderServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Sql(scripts = "/test-dataset.sql")
public class OrderServiceTest {

   @Autowired
   OrderServiceImp orderService;


    @Test
    public void getOrderTestSuccess() throws Exception {
        Resources<Resource<OrderDto>> listOfOrder = orderService.all();
        listOfOrder.getContent().size();

//        Assert.assert




    }

}
