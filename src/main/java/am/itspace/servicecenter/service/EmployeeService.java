package am.itspace.servicecenter.service;

import am.itspace.servicecenter.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    List<Employee> findAll();
}
