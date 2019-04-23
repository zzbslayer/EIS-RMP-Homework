package com.example.demo.Controller;

import com.example.demo.Domain.Entity.OrderEntity;
import com.example.demo.Domain.Entity.OrderProxy;
import com.example.demo.Service.OrderService;
import io.swagger.annotations.Api;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Order")
@Api(value="Order", description = "OrderController")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public OrderProxy getById(@PathVariable long id){
        return OrderProxy.create(orderService.getById(id));
    }

    @GetMapping("")
    public List<OrderProxy> get(@RequestParam(required = false) String mode, @RequestParam(required = false) Double latitude, @RequestParam(required = false) Double longitude, @RequestParam(required = false) Long userId){

        List<OrderEntity> res;
        if (mode == null || mode.equals("ALL"))
            res = orderService.getAll();
        else if (mode.equals("NEARBY"))
            res = orderService.getNearby(longitude, latitude);
        else if (mode.equals("USER"))
            res = orderService.getByUserId(userId);
        else if (mode.equals("PROXY"))
            res = orderService.getByProxyId(userId);
        else
            res = orderService.getAll();

        return OrderProxy.create(res);
    }

    @PostMapping("")
    public OrderProxy create(@RequestBody OrderEntity orderEntity, @RequestParam(defaultValue = "true") boolean createAddress){
        return OrderProxy.create(orderService.create(orderEntity, createAddress));
    }

    //todo
    @PutMapping("/{id}")
    public OrderProxy modify(@PathVariable long id, @RequestBody OrderProxy orderProxy){
        return OrderProxy.create(orderService.modify(id, OrderEntity.create(orderProxy)));
    }
}
