package com.nagarro.controller;

import com.nagarro.models.dto.requests.OrderDTORequest;
import com.nagarro.models.dto.responses.OrderDTOResponse;
import com.nagarro.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@Validated
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping(value = "", produces = {"application/json"})
    public ResponseEntity<String> createOrder(@RequestBody OrderDTORequest orderDTORequest) {
        orderService.placeOrder(orderDTORequest);
        return new ResponseEntity<>("Order created", HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<OrderDTOResponse> getOrder(@PathVariable("id") Long id) {
        return new ResponseEntity<>(orderService.findOrderById(id), HttpStatus.OK);
    }

}
