package com.nagarro.controller;

import com.nagarro.models.entities.OrderDBO;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class OrderControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Value("${server.servlet.contextPath}")
    private String uri;

    @Test
    public void testCreateOrder(){
        OrderDBO orderDBO = new OrderDBO();
        orderDBO.setStatus("New");
        orderDBO.setProductName("Shoes");
        orderDBO.setCustomerName("Hiten");

        ResponseEntity<String> response = restTemplate.postForEntity(
                createURLWithPort("/orders"), orderDBO, String.class);

        assertEquals(201, response.getStatusCodeValue());
    }

//    @Sql({ "/create-Orders_Schema.sql", "/insert-Orders_Data.sql" })
    @Test
    public void testRetrieveOrder() throws Exception {

        String response = restTemplate.getForObject(
                createURLWithPort("/orders/1"), String.class);

        String expected = "{\"id\":1,\"status\":\"New\",\"customerName\":\"Hiten\",\"productName\":\"Shoes\"}";

        JSONAssert.assertEquals(expected, response, false);
    }

    private String createURLWithPort(String endPoint) {
        return "http://localhost:" + port + uri + endPoint;
    }
}
