package com.nagarro.utils;

import com.nagarro.models.dto.responses.OrderDTOResponse;
import com.nagarro.models.entities.OrderDBO;

import java.sql.Timestamp;

public class DboToDtoConvertor {

    public static OrderDTOResponse convertOrderDboToDto(OrderDBO orderDBO) {

        Long id = orderDBO.getId();
        String customerName = orderDBO.getCustomerName();
        String productName = orderDBO.getProductName();
        String status = orderDBO.getStatus();
        Timestamp orderCreateDate = orderDBO.getCreateDate();
        Timestamp orderDeliveryDate = orderDBO.getDeliveryDate();

        return new OrderDTOResponse(id, status, customerName, productName, orderCreateDate, orderDeliveryDate);

    }
}
