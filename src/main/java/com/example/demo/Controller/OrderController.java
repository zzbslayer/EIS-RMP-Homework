package com.example.demo.Controller;

import com.example.demo.Domain.Entity.OrderEntity;
import com.example.demo.Service.OrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Order")
@Api(value="Order", description = "OrderController")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public OrderEntity getOrderById(@PathVariable long id){
        return orderService.getOrderById(id);
    }

    @GetMapping("")
    public List<OrderEntity> getOrder(){
        return orderService.getAll();
    }

    @PostMapping("")
    public OrderEntity createOrder(@RequestBody OrderEntity orderEntity){
        return orderService.createOrder(orderEntity);
    }

    @PutMapping("/{id}")
    public OrderEntity modifyOrder(@PathVariable long id, @RequestBody OrderEntity orderEntity){
        return orderService.modifyOrder(id, orderEntity);
    }
}
