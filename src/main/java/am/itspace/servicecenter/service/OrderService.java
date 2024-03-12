package am.itspace.servicecenter.service;

import am.itspace.servicecenter.entity.Order;

import java.util.List;

public interface OrderService {
    Order save(Order order);

    List<Order> findAll();
}
