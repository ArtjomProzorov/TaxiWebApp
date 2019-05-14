package com.sda.practical.order.OrderAssemblerResource;

import com.sda.practical.order.OrderDto.OrderDto;
import com.sda.practical.order.domain.Order;
import com.sda.practical.order.OrderRepository.OrderRepository;
import com.sda.practical.order.domain.OrderStatus;
import com.sda.practical.order.rest.OrderController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class OrderResourceAssembler implements ResourceAssembler<Order, Resource<OrderDto>> {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Resource<OrderDto> toResource(Order order) {


        OrderDto orderDto = new OrderDto();
        orderDto.setDescription(order.getDescription());
        orderDto.setStatus(order.getStatus());

        // Unconditional links to single-item resource and aggregate root
        Resource<OrderDto> orderResource = new Resource<>(orderDto,
                linkTo(methodOn(OrderController.class).one(order.getId())).withSelfRel(),
                linkTo(methodOn(OrderController.class).all()).withRel("orders"));

        //creating a resource of individual user


        //Conditional links based on a state of the order
        if (orderDto.getStatus() == OrderStatus.IN_PROGRESS) {
            try {
                orderResource.add(
                        linkTo(methodOn(OrderController.class)
                                .cancel(order.getId())).withRel("cancel"));
                orderResource.add(
                        linkTo(methodOn(OrderController.class)
                                .complete(order.getId())).withRel("complete"));

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return orderResource;
    }




}
