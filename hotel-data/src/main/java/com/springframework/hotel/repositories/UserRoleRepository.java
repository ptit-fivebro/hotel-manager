package com.springframework.hotel.repositories;

import com.springframework.hotel.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRoleRepository extends JpaRepository<UserRole, Long>{

}