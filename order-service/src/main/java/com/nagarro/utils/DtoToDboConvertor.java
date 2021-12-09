package com.nagarro.utils;

import com.nagarro.models.dto.requests.OrderDTORequest;
import com.nagarro.models.entities.OrderDBO;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DtoToDboConvertor {

    public static OrderDBO convertOrderDtoToDbo(OrderDTORequest orderDTORequest) {

        OrderDBO orderDBO = new OrderDBO();
        orderDBO.setCustomerName(orderDTORequest.customerName());
        orderDBO.setProductName(orderDTORequest.productName());
        orderDBO.setStatus(orderDTORequest.status());
        orderDBO.setCreateDate(LocalDateTime.now(ZoneOffset.UTC));

        return orderDBO;
    }
}
