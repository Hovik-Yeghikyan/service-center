package am.itspace.servicecenter.service.Impl;

import am.itspace.servicecenter.entity.Order;
import am.itspace.servicecenter.repository.OrderRepository;
import am.itspace.servicecenter.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
