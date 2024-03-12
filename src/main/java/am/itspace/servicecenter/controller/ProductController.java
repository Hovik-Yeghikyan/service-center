package am.itspace.servicecenter.controller;

import am.itspace.servicecenter.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;


@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

}
