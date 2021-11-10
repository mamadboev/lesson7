package com.example.jpa_relationships.jpa.services;

import com.example.jpa_relationships.jpa.dto.ApiResponse;
import com.example.jpa_relationships.jpa.dto.school.SchoolForm;
import org.springframework.data.domain.Pageable;

public interface SchoolService {
    ApiResponse list(Pageable pageable);

    ApiResponse view(Long id);

    ApiResponse add(SchoolForm schoolForm);

    ApiResponse update(Long id, SchoolForm schoolForm);

    ApiResponse delete(Long id);
}
