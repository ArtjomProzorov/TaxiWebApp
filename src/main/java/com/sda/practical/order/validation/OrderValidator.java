package com.sda.practical.order.validation;

import com.sda.practical.order.domain.Order;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class OrderValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Order.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Order order= (Order) target;

        if(order.getDescription() == null)
            errors.rejectValue("description", "description cannot be null");
    }
}
