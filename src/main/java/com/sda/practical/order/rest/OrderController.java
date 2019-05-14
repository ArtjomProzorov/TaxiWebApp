package com.sda.practical.order.rest;

import com.sda.practical.order.OrderDto.OrderDto;
import com.sda.practical.order.application.service.OrderImp.OrderServiceImp;
import com.sda.practical.order.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class OrderController {

    private final OrderServiceImp orderService;

    @Autowired
    public OrderController(OrderServiceImp orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public ResponseEntity<Resources<Resource<OrderDto>>> all(){
        return ResponseEntity.ok(orderService.all());
    }

    @GetMapping("/orders/{id}")
    public Order one(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @PostMapping("/orders")
    public ResponseEntity<Resource<OrderDto>> addOrder(@RequestBody OrderDto orderDto) throws Exception {
        return ResponseEntity.ok(orderService.addOrder(orderDto));
    }

    @DeleteMapping("/orders/{id}/cancel")
    public ResponseEntity<Resource<OrderDto>> cancel(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(orderService.cancel(id));
    }

    @PutMapping("/orders/{id}/complete")
    public ResponseEntity<ResourceSupport> complete(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(orderService.complete(id));
    }



}
