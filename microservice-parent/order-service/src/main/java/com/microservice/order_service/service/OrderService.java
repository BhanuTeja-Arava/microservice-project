package com.microservice.order_service.service;

import com.microservice.order_service.dto.OrderLineItemsDto;
import com.microservice.order_service.dto.OrderRequest;
import com.microservice.order_service.model.Order;
import com.microservice.order_service.model.OrderLineItems;
import com.microservice.order_service.repositroy.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void placeOrder(OrderRequest orderRequest) {

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> list = orderRequest.getOrderLineItemsDto()
                .stream().map(this::mapToDTO)
                .toList();
        order.setOrderLineItems(list);
        orderRepository.save(order);

    }

    private OrderLineItems mapToDTO(OrderLineItemsDto orderLineItemsDto) {

        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        return orderLineItems;
    }
}
