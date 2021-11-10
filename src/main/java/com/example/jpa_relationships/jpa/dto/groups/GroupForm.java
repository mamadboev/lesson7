package com.example.jpa_relationships.jpa.dto.groups;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupForm {
    private String name;

    private Long schoolId;
}
