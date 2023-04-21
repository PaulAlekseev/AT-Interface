package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class TaskModel {
    private Long id;
    private String serviceName;
    private int cost;
    private boolean done;
    private boolean success;
}
