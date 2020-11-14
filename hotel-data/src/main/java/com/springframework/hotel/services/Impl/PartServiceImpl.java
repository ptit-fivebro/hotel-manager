package com.springframework.hotel.services.Impl;

import com.springframework.hotel.models.Part;
import com.springframework.hotel.repositories.PartRepository;
import com.springframework.hotel.services.IPartService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PartServiceImpl implements IPartService {
    private PartRepository partRepository;

    public PartServiceImpl(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public List<Part> findAll() {
        List<Part> parts = new ArrayList<>();
        partRepository.findAll().forEach(parts::add);
        return parts;
    }

    @Override
    public Part findById(String s) {
        Optional<Part> part = partRepository.findById(s);
        return part.orElse(null);
    }

    @Override
    public Part save(Part object) {
        return partRepository.save(object);
    }

    @Override
    public void delete(Part object) {
        partRepository.delete(object);
    }

    @Override
    public void deleteById(String s) {
        partRepository.deleteById(s);
    }
}
