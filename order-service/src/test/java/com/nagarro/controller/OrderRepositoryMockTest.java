package com.nagarro.controller;

import com.nagarro.models.entities.OrderDBO;
import com.nagarro.repositories.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@DataJpaTest
public class OrderRepositoryMockTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void createOrder() {

        OrderDBO orderDBO = new OrderDBO();
        orderDBO.setStatus("New");
        orderDBO.setProductName("Shoes");
        orderDBO.setCustomerName("Hiten");
        orderDBO.setCreateDate(LocalDateTime.now(ZoneOffset.UTC));

        orderRepository.save(orderDBO);

//        Assert.assertNotNull(orderDBO.getId());
        Assert.notNull(orderDBO.getId(), "Id is not null");
    }


}
