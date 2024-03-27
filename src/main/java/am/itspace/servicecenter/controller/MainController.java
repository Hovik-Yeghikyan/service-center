package am.itspace.servicecenter.controller;

import am.itspace.servicecenter.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    @Value("${service_center.picture.upload.directory}")
    private String uploadDirectory;
    private ProductService productService;

    @GetMapping("/")
    public String homePage() {
        return "user/home";
    }
}
