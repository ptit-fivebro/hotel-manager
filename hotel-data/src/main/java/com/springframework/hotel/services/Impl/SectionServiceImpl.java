package com.springframework.hotel.services.Impl;

import java.util.List;

import com.springframework.hotel.models.Section;
import com.springframework.hotel.repositories.SectionRepository;
import com.springframework.hotel.services.ISectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionServiceImpl implements ISectionService {

    @Autowired
    private SectionRepository sectionRepository;

    @Override
    public List<Section> getSectionOption() {
        // TODO Auto-generated method stub
        return sectionRepository.findAll();
    }
}
