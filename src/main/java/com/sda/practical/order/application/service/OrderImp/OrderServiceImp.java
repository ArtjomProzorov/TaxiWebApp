package com.sda.practical.order.application.service.OrderImp;

import com.sda.practical.exceptions.OrderNotFoundException;
import com.sda.practical.order.OrderDto.OrderDto;
import com.sda.practical.order.OrderAssemblerResource.OrderResourceAssembler;
import com.sda.practical.order.application.service.OrderService;
import com.sda.practical.order.validation.OrderValidator;
import com.sda.practical.order.domain.Order;
import com.sda.practical.order.OrderRepository.OrderRepository;
import com.sda.practical.order.domain.OrderStatus;
import com.sda.practical.order.rest.OrderController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;
import org.springframework.validation.DataBinder;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class OrderServiceImp implements OrderService {

    private final OrderResourceAssembler assembler;
    private final OrderRepository orderRepository;
    private final OrderResourceAssembler orderResourceAssembler;

    @Autowired
    public OrderServiceImp(OrderResourceAssembler assembler, OrderRepository orderRepository, OrderResourceAssembler orderResourceAssembler) {
        this.assembler = assembler;
        this.orderRepository = orderRepository;
        this.orderResourceAssembler = orderResourceAssembler;
    }

    public Order findById(Long id){
        return orderRepository.findById(id).filter(order -> order.getId().equals(id)).orElse(null);

    }


    public Resource<OrderDto> addOrder(OrderDto orderDto) throws Exception {

        DataBinder binder = new DataBinder(orderDto);
        binder.addValidators(new OrderValidator());
        binder.validate();

        if (binder.getBindingResult().hasErrors())
            throw new Exception();

        Order order = Order.of(orderDto.getDescription(),orderDto.getStatus());
        orderDto.setStatus(OrderStatus.IN_PROGRESS);
        Order newOrder = orderRepository.save(order);

        return orderResourceAssembler.toResource(newOrder);
    }

    public Resource<OrderDto> cancel(Long id) throws Exception {

        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
        if (order.getStatus() != OrderStatus.IN_PROGRESS) {
            throw new Exception();
        }
        order.setStatus(OrderStatus.CANCELLED);
        return orderResourceAssembler.toResource(orderRepository.save(order));

    }

    public Resource<OrderDto> complete(Long id) throws Exception {
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
        if (order.getStatus() != OrderStatus.IN_PROGRESS) {
            throw new Exception();
        }
        order.setStatus(OrderStatus.COMPLETED);
        return orderResourceAssembler.toResource(orderRepository.save(order));
    }

    public Resources<Resource<OrderDto>> all(){

            List<Resource<OrderDto>> orders = orderRepository.findAll().stream().map(assembler::toResource)
                    .collect(Collectors.toList());

            return new Resources<>(orders,linkTo(methodOn(OrderController.class).all()).withSelfRel());
    }


}
