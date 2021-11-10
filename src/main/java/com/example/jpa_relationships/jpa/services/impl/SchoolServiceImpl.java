package com.example.jpa_relationships.jpa.services.impl;

import com.example.jpa_relationships.jpa.dto.ApiResponse;
import com.example.jpa_relationships.jpa.dto.school.SchoolForm;
import com.example.jpa_relationships.jpa.entity.School;
import com.example.jpa_relationships.jpa.repository.SchoolRepository;
import com.example.jpa_relationships.jpa.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public ApiResponse list(Pageable pageable) {
        return new ApiResponse("School lists: ", true, schoolRepository.findAll(pageable));
    }

    @Override
    public ApiResponse view(Long id) {
        return new ApiResponse("School one Data: ", true, schoolRepository.findById(id).orElse(null));
    }

    @Override
    public ApiResponse add(SchoolForm schoolForm) {
        School school = new School();
        school.setName(schoolForm.getName());
        schoolRepository.save(school);
        return new ApiResponse("School add", true, null);
    }

    @Override
    public ApiResponse update(Long id, SchoolForm schoolForm) {
        School school = schoolRepository.findById(id).orElse(null);
        if (school == null) {
            return new ApiResponse("School not found!", false, null);
        }
        school.setName(schoolForm.getName());
        return new ApiResponse("School update", true, school);
    }

    @Override
    public ApiResponse delete(Long id) {
        School school = schoolRepository.findById(id).orElse(null);
        if (school == null) {
            return new ApiResponse("School not found!", false, null);
        }
        schoolRepository.delete(school);
        return new ApiResponse("School deleted!", true, null);
    }
}
