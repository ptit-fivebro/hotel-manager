package com.springframework.hotel.services;

import com.springframework.hotel.models.AppRole;
import com.springframework.hotel.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public AppRole getRole(Long id) {
        return roleRepository.findById(id).get();
    }
}
