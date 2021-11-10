package com.example.jpa_relationships.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "subjects")
@AllArgsConstructor
@NoArgsConstructor
public class Subjects extends BaseEntity {
    private String result;

    private double level;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Students students;
}
