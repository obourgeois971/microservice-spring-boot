package com.techie.microservices.order.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.techie.microservices.order.dto.OrderRequest;
import com.techie.microservices.order.model.Order;
import com.techie.microservices.order.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

	private final OrderRepository orderRepository;
	
    public void placeOrder(OrderRequest orderRequest) { 
    	// map Orderrequest to order object
    	Order order = new Order();
    	order.setOrderNumber(UUID.randomUUID().toString());
    	order.setPrice(orderRequest.price());
    	order.setSkuCode(orderRequest.skuCode());
        order.setQuantity(orderRequest.quantity());
        
    	// save order to OrderRepository
        orderRepository.save(order);
    }
}