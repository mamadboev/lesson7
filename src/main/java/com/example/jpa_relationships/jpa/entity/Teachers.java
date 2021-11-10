package com.example.jpa_relationships.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "teachers")
@AllArgsConstructor
@NoArgsConstructor
public class Teachers extends BaseEntity {
    private String fullName;

    private String phoneNumber;

    private String address;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "teacher_group",
            joinColumns = {@JoinColumn(name = "teacher_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id")}
    )
    private List<Groups> groups;
}
