package com.example.jpa_relationships.jpa.services.impl;

import com.example.jpa_relationships.jpa.dto.ApiResponse;
import com.example.jpa_relationships.jpa.dto.groups.GroupForm;
import com.example.jpa_relationships.jpa.entity.Groups;
import com.example.jpa_relationships.jpa.entity.School;
import com.example.jpa_relationships.jpa.repository.GroupsRepository;
import com.example.jpa_relationships.jpa.repository.SchoolRepository;
import com.example.jpa_relationships.jpa.services.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GroupsServiceImpl implements GroupsService {
    @Autowired
    private GroupsRepository groupsRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public ApiResponse list(Pageable pageable) {
        return new ApiResponse("School lists: ", true, groupsRepository.findAll(pageable));
    }

    @Override
    public ApiResponse view(Long id) {
        Groups groups = groupsRepository.findById(id).orElse(null);
        if (groups == null) {
            return new ApiResponse("Group not found!", false, null);
        }
        return new ApiResponse("Group One Data", true, groups);
    }

    @Override
    public ApiResponse add(GroupForm groupForm) {
        Groups groups = new Groups();
        groups.setName(groupForm.getName());
        School school = schoolRepository.findById(groupForm.getSchoolId()).orElse(null);
        if (school == null) {
            return new ApiResponse("School not found!", true, null);
        }
        groups.setSchool(school);
        groupsRepository.save(groups);
        return new ApiResponse("Group Saved", true, groups);
    }

    @Override
    public ApiResponse update(Long id, GroupForm groupForm) {
        Groups groups = groupsRepository.findById(id).orElse(null);
        if (groups == null) {
            return new ApiResponse("Group not found!", true, null);
        }
        School school = schoolRepository.findById(groupForm.getSchoolId()).orElse(null);
        if (school == null) {
            return new ApiResponse("School not found!", true, null);
        }
        groups.setSchool(school);
        groupsRepository.save(groups);
        return new ApiResponse("Group Update", true, groups);
    }

    @Override
    public ApiResponse delete(Long id) {
        Groups groups = groupsRepository.findById(id).orElse(null);
        if (groups == null) {
            return new ApiResponse("Group not found!", true, null);
        }
        groupsRepository.delete(groups);
        return new ApiResponse("Group Deleted!", true, null);
    }
}
