package com.springframework.hotel.repositories;

import com.springframework.hotel.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(CustomQuery.EMPLOYEE_SEARCH)
    Page<Employee> searchEmployees(Pageable pageable, @Param("text") String text);

    @Transactional
    @Modifying
    @Query(CustomQuery.EMPLOYEE_UPDATE)
    void updateEmployee(@Param("employeeNumber") String employeeNumber,
                        @Param("employeeName") String employeeName,
                        @Param("birth") String birth,
                        @Param("gender") String gender,
                        @Param("address") String address,
                        @Param("email") String email,
                        @Param("phoneNumber") String phoneNumber,
                        @Param("salary") String salary,
                        @Param("managerNumber") String managerNumber,
                        @Param("employeeId") Long employeeId);
}
