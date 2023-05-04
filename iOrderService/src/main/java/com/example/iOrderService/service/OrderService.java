package com.example.iOrderService.service;

import com.example.iOrderService.model.OrderRequest;

public interface OrderService {
    Long placeOrder(OrderRequest orderRequest);
}
