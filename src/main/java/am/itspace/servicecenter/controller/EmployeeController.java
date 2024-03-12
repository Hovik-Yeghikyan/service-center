package am.itspace.servicecenter.controller;

import am.itspace.servicecenter.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class EmployeeController {
    private EmployeeRepository employeeRepository;
}
