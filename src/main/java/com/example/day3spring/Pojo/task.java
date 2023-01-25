package com.example.day3spring.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class task {
    private String id;
    private String title;
    private String description;
    private String status;

}
