package com.example.jpa_relationships.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "school")
@AllArgsConstructor
@NoArgsConstructor
public class School extends BaseEntity {
    private String name;
}
