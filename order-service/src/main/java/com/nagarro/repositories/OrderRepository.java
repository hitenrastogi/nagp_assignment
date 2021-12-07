package com.nagarro.repositories;

import com.nagarro.models.entities.OrderDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderDBO, Long> {
}
