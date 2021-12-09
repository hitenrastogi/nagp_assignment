package com.nagarro.services;

import com.nagarro.models.dto.requests.OrderDTORequest;
import com.nagarro.models.dto.responses.OrderDTOResponse;

public interface OrderService {

    void placeOrder(OrderDTORequest orderDTORequest);

    OrderDTOResponse findOrderById(Long id);
}
