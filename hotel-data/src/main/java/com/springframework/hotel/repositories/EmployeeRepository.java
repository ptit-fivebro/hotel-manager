package com.springframework.hotel.repositories;

import com.springframework.hotel.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
