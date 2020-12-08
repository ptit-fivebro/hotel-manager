package com.springframework.hotel.services;

import com.springframework.hotel.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {

    Employee findEmployee(Long id);

    Page<Employee> searchEmployees(Pageable pageable, String text);

    void editEmployeeInfo(String employeeNumber, String employeeName, String birth, String gender, String address, String email, String phoneNumber, String salary, String managerNumber, Long employeeId);

    void addEmployee(String employeeNumber, String employeeName, String birth, String gender, String address, String email, String phoneNumber, String salary, String managerNumber);
}
