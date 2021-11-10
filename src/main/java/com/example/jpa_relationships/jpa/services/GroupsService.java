package com.example.jpa_relationships.jpa.services;

import com.example.jpa_relationships.jpa.dto.ApiResponse;
import com.example.jpa_relationships.jpa.dto.groups.GroupForm;
import org.springframework.data.domain.Pageable;

public interface GroupsService {
    ApiResponse list(Pageable pageable);

    ApiResponse view(Long id);

    ApiResponse add(GroupForm groupForm);

    ApiResponse update(Long id, GroupForm groupForm);

    ApiResponse delete(Long id);
}
