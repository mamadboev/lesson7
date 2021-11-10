package com.example.jpa_relationships.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "groups")
@AllArgsConstructor
@NoArgsConstructor
public class Groups extends BaseEntity {
    private String name;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
}
