package com.nagarro.models.dto.requests;

import java.sql.Timestamp;

public record OrderDTORequest(String status, String customerName,
                              String productName, Timestamp createDate, Timestamp deliveryDate) {

}
