package am.itspace.servicecenter.service;

import am.itspace.servicecenter.entity.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    List<Product> findAll();

    Product findById(int id);

}
