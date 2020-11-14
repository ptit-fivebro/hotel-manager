package com.springframework.hotel.services.Impl;

import com.springframework.hotel.models.Service;
import com.springframework.hotel.repositories.ServiceRepository;
import com.springframework.hotel.services.IServiceService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceServiceImpl implements IServiceService {
    private ServiceRepository serviceRepository;
    @Override
    public List<Service> findAll() {
        List<Service>services=new ArrayList<>();
        serviceRepository.findAll().forEach(services::add);
        return services;
    }

    @Override
    public Service findById(Integer integer) {
        Optional<Service>service=serviceRepository.findById(integer);
        return service.orElse(null);
    }

    @Override
    public Service save(Service object) {
        return serviceRepository.save(object);
    }

    @Override
    public void delete(Service object) {
        serviceRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        serviceRepository.deleteById(integer);
    }
}
