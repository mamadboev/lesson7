package com.example.jpa_relationships.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private String message;
    private boolean success;
    private Object list = new ArrayList<>();
}
