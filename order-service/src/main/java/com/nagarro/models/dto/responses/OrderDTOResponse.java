package com.nagarro.models.dto.responses;

import java.time.LocalDateTime;

public record OrderDTOResponse(Long id, String status, String customerName,
                               String productName, LocalDateTime createDate) {

}
