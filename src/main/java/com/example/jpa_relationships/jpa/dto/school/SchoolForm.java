package com.example.jpa_relationships.jpa.dto.school;

import com.example.jpa_relationships.jpa.entity.Groups;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolForm {
    private String name;

    private Set<Groups> groups;
}
