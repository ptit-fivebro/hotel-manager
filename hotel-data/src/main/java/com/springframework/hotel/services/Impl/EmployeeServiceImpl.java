package com.springframework.hotel.services.Impl;

import com.springframework.hotel.models.Employee;
import com.springframework.hotel.repositories.EmployeeRepository;
import com.springframework.hotel.services.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    @Override
    public Employee findById(Integer integer) {
        Optional<Employee> employee = employeeRepository.findById(integer);
        return employee.orElse(null);
    }

    @Override
    public Employee save(Employee object) {
        return employeeRepository.save(object);
    }

    @Override
    public void delete(Employee object) {
        employeeRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        employeeRepository.deleteById(integer);
    }
}
