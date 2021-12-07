package com.nagarro.utils;

import com.nagarro.models.dto.requests.OrderDTORequest;
import com.nagarro.models.entities.OrderDBO;

public class DtoToDboConvertor {

    public static OrderDBO convertOrderDtoToDbo(OrderDTORequest orderDTORequest) {

        OrderDBO orderDBO = new OrderDBO();
        orderDBO.setCustomerName(orderDTORequest.customerName());
        orderDBO.setProductName(orderDTORequest.productName());
        orderDBO.setStatus("New");
        orderDBO.setCreateDate(AppUtil.getCurrentUtcTimestamp());

        return orderDBO;
    }
}
