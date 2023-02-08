package com.salatin.carrepairuserservice.model;

import com.salatin.carrepairuserservice.model.status.OrderStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime customerRequestedAt;
    private LocalDateTime startRepairAt;
    private LocalDateTime finishRepairAt;
    private LocalDateTime submittedAt;
    private List<Part> parts;
    private List<Work> works;
    private LocalDateTime totalExecutionTime;
    private BigDecimal total;
    private OrderStatus status;
}
