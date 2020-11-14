package com.springframework.hotel.services.Impl;

import com.springframework.hotel.models.ServiceCategory;
import com.springframework.hotel.repositories.ServiceCategoryRepository;
import com.springframework.hotel.services.IServiceCategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceCategoryServiceImpl implements IServiceCategoryService {
    private ServiceCategoryRepository serviceCategoryRepository;

    public ServiceCategoryServiceImpl(ServiceCategoryRepository serviceCategoryRepository) {
        this.serviceCategoryRepository = serviceCategoryRepository;
    }

    @Override
    public List<ServiceCategory> findAll() {
        List<ServiceCategory> serviceCategories = new ArrayList<>();
        serviceCategoryRepository.findAll().forEach(serviceCategories::add);
        return serviceCategories;
    }

    @Override
    public ServiceCategory findById(Integer integer) {
        Optional<ServiceCategory> serviceCategory = serviceCategoryRepository.findById(integer);
        return serviceCategory.orElse(null);
    }

    @Override
    public ServiceCategory save(ServiceCategory object) {
        return serviceCategoryRepository.save(object);
    }

    @Override
    public void delete(ServiceCategory object) {
        serviceCategoryRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        serviceCategoryRepository.deleteById(integer);
    }
}
