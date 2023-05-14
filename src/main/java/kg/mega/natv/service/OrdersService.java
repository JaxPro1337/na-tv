package kg.mega.natv.service;

import kg.mega.natv.models.dto.OrderDto;
import kg.mega.natv.models.dto.OrderResponseDto;

public interface OrdersService {
    OrderResponseDto appendOrder(OrderDto orderDto);
}
