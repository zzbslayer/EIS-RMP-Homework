package com.example.demo.Controller;

import com.example.demo.Domain.Entity.OrderEntity;
import com.example.demo.Domain.Entity.OrderProxy;
import com.example.demo.Service.OrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/v2/Order")
@Api(value="Order", description = "OrderController")
public class OrderControllerV2 {
    @Autowired
    private OrderService orderService;

    @PostMapping("")
    public OrderProxy create(@RequestBody OrderProxy orderProxy, @RequestParam(defaultValue = "true") boolean createAddress){
        return OrderProxy.create(orderService.create(OrderEntity.create(orderProxy), createAddress));
    }

    @PutMapping("/{id}")
    public OrderProxy modify(@PathVariable long id, @RequestBody OrderProxy orderProxy){
        return OrderProxy.create(orderService.modify(id, OrderEntity.create(orderProxy)));
    }

}
