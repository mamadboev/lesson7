package com.example.jpa_relationships.jpa.controllers;

import com.example.jpa_relationships.jpa.dto.school.SchoolForm;
import com.example.jpa_relationships.jpa.services.impl.SchoolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/school")
public class SchoolController {
    @Autowired
    private SchoolServiceImpl schoolService;

    @GetMapping("/list")
    public ResponseEntity list(Pageable pageable) {
        return ResponseEntity.ok(schoolService.list(pageable));
    }

    @GetMapping("/view/{id}")
    public ResponseEntity view(@PathVariable("id") Long id) {
        return ResponseEntity.ok(schoolService.view(id));
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody SchoolForm schoolForm) {
        return ResponseEntity.ok(schoolService.add(schoolForm));
    }

    @PutMapping("/update/{id]")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody SchoolForm schoolForm) {
        return ResponseEntity.ok(schoolService.update(id, schoolForm));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(schoolService.delete(id));
    }

}
