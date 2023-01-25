package com.example.day3spring.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class customer {
    private String id;
    private String userName;
    private int Balance=0;
}
