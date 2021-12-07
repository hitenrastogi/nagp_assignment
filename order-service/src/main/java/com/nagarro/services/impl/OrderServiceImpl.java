package com.nagarro.services.impl;

import com.nagarro.models.dto.requests.OrderDTORequest;
import com.nagarro.models.dto.responses.OrderDTOResponse;
import com.nagarro.models.entities.OrderDBO;
import com.nagarro.repositories.OrderRepository;
import com.nagarro.services.OrderService;
import com.nagarro.utils.DboToDtoConvertor;
import com.nagarro.utils.DtoToDboConvertor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public void placeOrder(OrderDTORequest orderDTORequest) {
        OrderDBO orderDBO = DtoToDboConvertor.convertOrderDtoToDbo(orderDTORequest);
        orderRepository.save(orderDBO);
    }

    @Override
    public OrderDTOResponse findOrderById(Long id) {
        OrderDBO orderDBO = orderRepository.getById(id);
        return DboToDtoConvertor.convertOrderDboToDto(orderDBO);
    }
}
