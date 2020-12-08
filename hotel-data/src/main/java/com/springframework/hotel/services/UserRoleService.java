package com.springframework.hotel.services;

import com.springframework.hotel.models.UserRole;
import com.springframework.hotel.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    public void saveUserRole(UserRole userRole) {
        userRoleRepository.save(userRole);
    }
}
