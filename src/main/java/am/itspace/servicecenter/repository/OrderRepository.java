package am.itspace.servicecenter.repository;

import am.itspace.servicecenter.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
