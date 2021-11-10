package com.example.jpa_relationships.jpa.controllers;

import com.example.jpa_relationships.jpa.dto.groups.GroupForm;
import com.example.jpa_relationships.jpa.dto.school.SchoolForm;
import com.example.jpa_relationships.jpa.services.impl.GroupsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupsController {
    @Autowired
    private GroupsServiceImpl groupsService;

    @GetMapping("/list")
    public ResponseEntity list(Pageable pageable) {
        return ResponseEntity.ok(groupsService.list(pageable));
    }

    @GetMapping("/view/{id}")
    public ResponseEntity view(@PathVariable("id") Long id) {
        return ResponseEntity.ok(groupsService.view(id));
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody GroupForm groupForm) {
        return ResponseEntity.ok(groupsService.add(groupForm));
    }

    @PutMapping("/update/{id]")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody GroupForm groupForm) {
        return ResponseEntity.ok(groupsService.update(id, groupForm));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(groupsService.delete(id));
    }
}
