package kg.mega.natv.controller;

import kg.mega.natv.models.dto.OrderDto;
import kg.mega.natv.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrdersController {
    private final OrdersService ordersService;

    @PostMapping("/append_order")
    public ResponseEntity<?> appendOrder (@RequestBody OrderDto orderDto){

        return ResponseEntity.ok(ordersService.appendOrder(orderDto));
    }
}
