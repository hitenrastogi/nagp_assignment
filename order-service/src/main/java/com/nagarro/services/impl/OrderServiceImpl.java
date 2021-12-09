package com.nagarro.services.impl;

import com.nagarro.exceptions.OrderCreationException;
import com.nagarro.exceptions.OrderInvalidException;
import com.nagarro.models.dto.requests.OrderDTORequest;
import com.nagarro.models.dto.responses.OrderDTOResponse;
import com.nagarro.models.entities.OrderDBO;
import com.nagarro.repositories.OrderRepository;
import com.nagarro.services.OrderService;
import com.nagarro.utils.DboToDtoConvertor;
import com.nagarro.utils.DtoToDboConvertor;
import lombok.RequiredArgsConstructor;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public void placeOrder(OrderDTORequest orderDTORequest) {
        try {
            OrderDBO orderDBO = DtoToDboConvertor.convertOrderDtoToDbo(orderDTORequest);
            orderRepository.save(orderDBO);
        } catch (Exception e) {
            throw new OrderCreationException(e);
        }
    }

    @Override
    public OrderDTOResponse findOrderById(Long id) {

        Optional<OrderDBO> optionalOrderDBO = orderRepository.findById(id);
        OrderDBO orderDBO;
        if(optionalOrderDBO.isPresent()) {
            orderDBO = optionalOrderDBO.get();
        } else {
            throw new OrderInvalidException("Order Not Found");
        }
        return DboToDtoConvertor.convertOrderDboToDto(orderDBO);
    }
}
