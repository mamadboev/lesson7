package com.example.jpa_relationships.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
public class Students extends BaseEntity {
    private String fullName;

    private String address;

    private String parentPhoneNumber;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Groups groups;
}
