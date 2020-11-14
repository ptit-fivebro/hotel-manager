package com.springframework.hotel.services.Impl;

import com.springframework.hotel.models.ServiceDetail;
import com.springframework.hotel.repositories.ServiceDetailRepository;
import com.springframework.hotel.services.IServiceDetailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceDetailServiceImpl implements IServiceDetailService {
    private ServiceDetailRepository serviceDetailRepository;

    public ServiceDetailServiceImpl(ServiceDetailRepository serviceDetailRepository) {
        this.serviceDetailRepository = serviceDetailRepository;
    }

    @Override
    public List<ServiceDetail> findAll() {
        List<ServiceDetail> serviceDetails = new ArrayList<>();
        serviceDetailRepository.findAll().forEach(serviceDetails::add);
        return serviceDetails;
    }

    @Override
    public ServiceDetail findById(Integer integer) {
        Optional<ServiceDetail> serviceDetail = serviceDetailRepository.findById(integer);
        return serviceDetail.orElse(null);
    }

    @Override
    public ServiceDetail save(ServiceDetail object) {
        return serviceDetailRepository.save(object);
    }

    @Override
    public void delete(ServiceDetail object) {
        serviceDetailRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        serviceDetailRepository.deleteById(integer);
    }
}
