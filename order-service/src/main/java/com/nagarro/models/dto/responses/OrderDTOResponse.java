package com.nagarro.models.dto.responses;

import java.sql.Timestamp;

public record OrderDTOResponse(Long id, String status, String customerName,
                               String productName, Timestamp createDate, Timestamp deliveryDate) {

}
