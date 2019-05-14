package com.sda.practical.order.application.service;


import com.sda.practical.order.OrderDto.OrderDto;
import com.sda.practical.order.domain.Order;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;


public interface OrderService {


    Order findById(Long id);

    Resource<OrderDto> addOrder(OrderDto orderDto) throws Exception;

    Resource<OrderDto> cancel(Long id) throws Exception;

    Resource<OrderDto> complete(Long id) throws Exception;

    Resources<Resource<OrderDto>> all();



}
