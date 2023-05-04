package com.example.iOrderService.service;

import com.example.iOrderService.entity.OrderEntity;
import com.example.iOrderService.model.OrderRequest;
import com.example.iOrderService.respository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Long placeOrder(OrderRequest orderRequest) { //TODO make this method as transactions
        // all or nothing
        log.info("OrderService placeOrder save to orderdb start");

        //call orderservice(this) to create order entity with status CREATED, save to orderdb
        OrderEntity orderEntity = OrderEntity.builder()
                .productId(orderRequest.getProductId())
                .orderQuantity(orderRequest.getOrderQuantity())
                .totalAmount(orderRequest.getTotalAmount())
                .orderStatus("CREATED")
                .orderDate(Instant.now())
                .paymentMode(orderRequest.getPaymentMode())
                .build();
        orderEntity = orderRepository.save(orderEntity);
        log.info("OrderService placeOrder save to orderdb done");
        //call productservice to check quantity and reducequantity if ok

        //call payment service to charge payment modes, mark order completed if success,otherwise mark cancelled


        return orderEntity.getOrderId();
    }
}
