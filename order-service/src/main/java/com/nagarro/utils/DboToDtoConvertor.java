package com.nagarro.utils;

import com.nagarro.models.dto.responses.OrderDTOResponse;
import com.nagarro.models.entities.OrderDBO;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DboToDtoConvertor {

    public static OrderDTOResponse convertOrderDboToDto(OrderDBO orderDBO) {

        Long id = orderDBO.getId();
        String customerName = orderDBO.getCustomerName();
        String productName = orderDBO.getProductName();
        String status = orderDBO.getStatus();
        LocalDateTime orderCreateDate = orderDBO.getCreateDate();

        return new OrderDTOResponse(id, status, customerName, productName, orderCreateDate);

    }
}
