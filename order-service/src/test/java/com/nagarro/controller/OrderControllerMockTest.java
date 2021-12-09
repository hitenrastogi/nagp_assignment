package com.nagarro.controller;

import com.nagarro.models.dto.responses.OrderDTOResponse;
import com.nagarro.services.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
public class OrderControllerMockTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private OrderService orderService;

    @Test
    public void getOrderByIdAPI() throws Exception {
        Long id = 1L;
        OrderDTOResponse orderDTOResponse = new OrderDTOResponse(id, "New", "Hiten Rastogi", "Shoes", LocalDateTime.now(ZoneOffset.UTC));
        Mockito.when(orderService.findOrderById(id)).thenReturn(orderDTOResponse);
        mvc.perform( MockMvcRequestBuilders
                        .get("/orders/{id}", id)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }
}
