package com.example.jpa_relationships.jpa.repository;

import com.example.jpa_relationships.jpa.entity.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsRepository extends JpaRepository<Groups, Long> {
}
