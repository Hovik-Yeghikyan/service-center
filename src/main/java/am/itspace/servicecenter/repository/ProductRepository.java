package am.itspace.servicecenter.repository;

import am.itspace.servicecenter.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
